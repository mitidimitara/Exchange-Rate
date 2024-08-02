package com.mitidimitara.exchangeRate.domain.util

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaseUseCase {

    abstract class UseCase<in Input, out Output> where Output : Any {

        suspend fun invoke(
            input: Input,
            coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
        ): Result<Output, java.lang.Exception> =
            withContext(coroutineDispatcher) {
                try {
                    execute(input)
                } catch (exception: java.lang.Exception) {
                    Err(exception)
                }
            }

        @Throws(RuntimeException::class)
        protected abstract suspend fun execute(input: Input): Result<Output, java.lang.Exception>
    }

    /**
     * A base class that should be extended whenever an Use Case WITHOUT params is created.
     * */
    abstract class UseCaseNoParams<out Output> where Output : Any {

        suspend fun invoke(
            coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
        ): Result<Output, Exception> =
            withContext(coroutineDispatcher) {
                try {
                    execute()
                } catch (exception: Exception) {
                    Err(exception)
                }
            }

        @Throws(RuntimeException::class)
        protected abstract suspend fun execute(): Result<Output, Exception>
    }
}