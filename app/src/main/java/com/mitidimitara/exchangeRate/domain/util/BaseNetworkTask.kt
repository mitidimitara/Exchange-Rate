package com.mitidimitara.exchangeRate.domain.util

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.mitidimitara.exchangeRate.domain.util.NetworkTask.Companion.BASE_ERROR_MESSAGE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException

/**
 * A base task that takes in params
 *
 * @property Input is the type held in the response
 * @property Output is the parameter taken in
 */
abstract class NetworkTask<in Input, Output> {

    companion object {
        const val BASE_ERROR_MESSAGE = "Something went wrong."
    }

    /**
     * Method called to execute this task
     *
     * @param params are the parameters needed to provide the result
     */
    suspend fun execute(params: Input): Result<Output, Exception> =
        withContext(Dispatchers.IO) {
            try {
                val apiResponse = provideResponse(params)

                if (apiResponse.isSuccessful) {
                    apiResponse.body()?.let {
                        Ok(it)
                    } ?: Err(Exception(BASE_ERROR_MESSAGE))
                } else {
                    Err(Exception(BASE_ERROR_MESSAGE))
                }
            } catch (e: IOException) {
                Err(e)
            }
        }

    /**
     * Method to provide the response
     *
     * @param params are the parameters needed to provide the response
     *
     * @return a response of type [Output]
     */
    abstract suspend fun provideResponse(params: Input): Response<Output>
}

/**
 * A base task that takes in no params
 *
 * @property Output is the type held in the response
 */
abstract class NetworkTaskNoParams<Output> {

    /**
     * Method called to execute this task
     */
    suspend fun execute(): Result<Output, Exception> =
        withContext(Dispatchers.IO) {
            try {
                val apiResponse = provideResponse()

                if (apiResponse.isSuccessful) {
                    apiResponse.body()?.let {
                        Ok(it)
                    } ?: Err(Exception(BASE_ERROR_MESSAGE))
                } else {
                    Err(Exception(BASE_ERROR_MESSAGE))
                }
            } catch (e: IOException) {
                Err(e)
            }
        }

    /**
     * Method to provide the response
     *
     * @return a response of type [Output]
     */
    abstract suspend fun provideResponse(): Response<Output>
}