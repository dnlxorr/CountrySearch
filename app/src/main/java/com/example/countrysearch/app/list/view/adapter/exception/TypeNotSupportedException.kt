package com.example.countrysearch.app.list.view.adapter.exception

class TypeNotSupportedException private constructor(message: String) : RuntimeException(message) {
    companion object {

        fun create(message: String): TypeNotSupportedException {
            return TypeNotSupportedException(message)
        }
    }
}