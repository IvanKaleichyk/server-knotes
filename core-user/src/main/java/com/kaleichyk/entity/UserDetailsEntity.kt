package com.kaleichyk.entity

import com.kaleichyk.table.UserDetailsTable
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserDetailsEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UserDetailsEntity>(UserDetailsTable)

    var name by UserDetailsTable.name
    var email by UserDetailsTable.email
    var image by UserDetailsTable.image
    var about by UserDetailsTable.about
    val lastUpdated by UserDetailsTable.lastUpdated
}
