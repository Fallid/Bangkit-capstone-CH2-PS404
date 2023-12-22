from fastapi import FastAPI
import pandas as pd

app = FastAPI()

# Load and preprocess data
df = pd.read_hdf('processed_dataset_lokasi.h5', 'df')

# Select relevant features
data_model = df[['Place_Name', 'City', 'Images', 'Price',
                 'Rating', 'Lat', 'Long', 'Category', 'Description', 'Hotel']]

# Handle duplicates and missing data
data_model.drop_duplicates(inplace=True)
data_model.dropna(inplace=True)


def format_output(row):
    return {
        "place_name": row["Place_Name"],
        "city": row["City"],
        "images": row["Images"],
        "price": row["Price"],
        "rating": row["Rating"],
        "latitude": row["Lat"],
        "longitude": row["Long"],
        "category": row["Category"],
        "description": row["Description"],
        "hotel": row["Hotel"]
    }


@app.get('/')
def read_root():
    return {"Hello": "World"}


@app.get('/recommendations/{city}/{budget}')
def get_recommendations(city: str, budget: float, top_n: int = 10):
    recommendations = data_model[
        (data_model['City'].str.contains(city, case=False, na=False)) & (data_model['Price'] <= budget)]
    recommendations['abs_diff'] = abs(recommendations['Price'] - budget)
    recommendations.sort_values(by='abs_diff', ascending=True, inplace=True)
    result = recommendations.head(top_n).apply(format_output, axis=1)
    return result.to_list()


@app.get('/recommendations/{city}')
def get_recommendations_by_city(city: str, top_n: int = 10):
    recommendations = data_model[
        (data_model['City'].str.contains(city, case=False, na=False))]
    result = recommendations.head(top_n).apply(format_output, axis=1)
    return result.to_list()
