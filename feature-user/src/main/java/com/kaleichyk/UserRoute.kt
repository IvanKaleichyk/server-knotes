package com.kaleichyk

import com.kaleichyk.controller.UserController
import com.kaleichyk.extensions.ChangedData
import com.kaleichyk.models.UserDetails
import com.kaleichyk.service.UserService.Companion.USER_DEFAULT_PAGE
import com.kaleichyk.service.UserService.Companion.USER_PER_PAGE
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

fun Routing.createUserRoute(controller: UserController) {

    route("user") {
        get {
            val page: Int
            val perPage: Int
            call.request.queryParameters.run {
                page = this["page"]?.toInt() ?: USER_DEFAULT_PAGE
                perPage = this["per_page"]?.toInt() ?: USER_PER_PAGE
                val response = controller.getUsers(page, perPage)
                call.respond(response)
            }
        }

        post { userDetails: UserDetails ->
            val response = controller.addUser(userDetails)
            call.respond(response)
        }

        get("/{id}") {
            val id = call.parameters["id"]?.toLong() ?: -1
            val response = controller.getUser(id)
            call.respond(response)
        }

        post("set_name") { data: ChangedData<String> ->
            val response = controller.setUserName(data.id, data.content)
            call.respond(response)
        }

        post("set_image") { data: ChangedData<String> ->
            val response = controller.setUserImage(data.id, data.content)
            call.respond(response)
        }
    }
}
