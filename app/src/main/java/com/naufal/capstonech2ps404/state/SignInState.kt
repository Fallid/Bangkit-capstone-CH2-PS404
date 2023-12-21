package com.naufal.capstonech2ps404.state

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)