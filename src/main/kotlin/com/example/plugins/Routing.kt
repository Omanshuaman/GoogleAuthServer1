package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import com.example.domain.repository.UserDataSource
import com.example.routes.*
import org.koin.java.KoinJavaComponent.inject

fun Application.configureRouting() {

    routing {
        val userDataSource: UserDataSource by inject(UserDataSource::class.java)
        rootRoute()
        tokenVerificationRoute(application,userDataSource)
        getUserInfoRoute(application, userDataSource)
        updateUserRoute(application, userDataSource)
        deleteUserRoute(application, userDataSource)
        signOutRoute()
        authorizedRoute()
        unauthorizedRoute()
    }
}
