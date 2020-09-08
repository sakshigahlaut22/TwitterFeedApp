package com.sample.algoworktwitterfeed.network

class Resource<T>(status: Resource.Status, data: T?, message: String?) {

    val status: Resource.Status
    val data: T?
    val message: String?

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Resource.Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Resource.Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Resource.Status.LOADING, data, null)
        }
    }

    init {
        this.status = status
        this.data = data
        this.message = message
    }
}
