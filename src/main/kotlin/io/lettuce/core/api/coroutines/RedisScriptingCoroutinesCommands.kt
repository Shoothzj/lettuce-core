/*
 * Copyright 2020-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.lettuce.core.api.coroutines

import io.lettuce.core.ExperimentalLettuceCoroutinesApi
import io.lettuce.core.FlushMode
import io.lettuce.core.ScriptOutputType

/**
 * Coroutine executed commands for Scripting. [java.lang.String Lua scripts] are encoded by using the configured
 * [io.lettuce.core.ClientOptions#getScriptCharset charset].
 *
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mikhael Sokolov
 * @since 6.0
 * @generated by io.lettuce.apigenerator.CreateKotlinCoroutinesApi
 */
@ExperimentalLettuceCoroutinesApi
interface RedisScriptingCoroutinesCommands<K : Any, V : Any> {

    /**
     * Execute a Lua script server side.
     *
     * @param script Lua 5.1 script.
     * @param type output type.
     * @param keys key names.
     * @param <T> expected return type.
     * @return script result.
     */
    suspend fun <T> eval(script: String, type: ScriptOutputType, vararg keys: K): T?

    /**
     * Execute a Lua script server side.
     *
     * @param script Lua 5.1 script.
     * @param type output type.
     * @param keys key names.
     * @param <T> expected return type.
     * @return script result.
     * @since 6.0
     */
    suspend fun <T> eval(script: ByteArray, type: ScriptOutputType, vararg keys: K): T?

    /**
     * Execute a Lua script server side.
     *
     * @param script Lua 5.1 script.
     * @param type the type.
     * @param keys the keys.
     * @param values the values.
     * @param <T> expected return type.
     * @return script result.
     */
    suspend fun <T> eval(script: String, type: ScriptOutputType, keys: Array<K>, vararg values: V): T?

    /**
     * Execute a Lua script server side.
     *
     * @param script Lua 5.1 script.
     * @param type the type.
     * @param keys the keys.
     * @param values the values.
     * @param <T> expected return type.
     * @return script result.
     * @since 6.0
     */
    suspend fun <T> eval(script: ByteArray, type: ScriptOutputType, keys: Array<K>, vararg values: V): T?

    /**
     * Evaluates a script cached on the server side by its SHA1 digest.
     *
     * @param digest SHA1 of the script.
     * @param type the type.
     * @param keys the keys.
     * @param <T> expected return type.
     * @return script result.
     */
    suspend fun <T> evalsha(digest: String, type: ScriptOutputType, vararg keys: K): T?

    /**
     * Execute a Lua script server side.
     *
     * @param digest SHA1 of the script.
     * @param type the type.
     * @param keys the keys.
     * @param values the values.
     * @param <T> expected return type.
     * @return script result.
     */
    suspend fun <T> evalsha(digest: String, type: ScriptOutputType, keys: Array<K>, vararg values: V): T?

    /**
     * Check existence of scripts in the script cache.
     *
     * @param digests script digests.
     * @return List<Boolean> array-reply The command returns an array of integers that correspond to the specified SHA1
     *         digest arguments. For every corresponding SHA1 digest of a script that actually exists in the script cache, an 1
     *         is returned, otherwise 0 is returned.
     */
    suspend fun scriptExists(vararg digests: String): List<Boolean>

    /**
     * Remove all the scripts from the script cache.
     *
     * @return String simple-string-reply.
     */
    suspend fun scriptFlush(): String?

    /**
     * Remove all the scripts from the script cache using the specified [FlushMode].
     *
     * @param flushMode the flush mode (sync/async).
     * @return String simple-string-reply.
     * @since 6.1
     */
    suspend fun scriptFlush(flushMode: FlushMode): String?

    /**
     * Kill the script currently in execution.
     *
     * @return String simple-string-reply.
     */
    suspend fun scriptKill(): String?

    /**
     * Load the specified Lua script into the script cache.
     *
     * @param script script content.
     * @return String bulk-string-reply This command returns the SHA1 digest of the script added into the script cache.
     * @since 6.0
     */
    suspend fun scriptLoad(script: String): String?

    /**
     * Load the specified Lua script into the script cache.
     *
     * @param script script content.
     * @return String bulk-string-reply This command returns the SHA1 digest of the script added into the script cache.
     * @since 6.0
     */
    suspend fun scriptLoad(script: ByteArray): String?

    /**
     * Create a SHA1 digest from a Lua script.
     *
     * @param script script content.
     * @return the SHA1 value.
     * @since 6.0
     */
    suspend fun digest(script: String): String?

    /**
     * Create a SHA1 digest from a Lua script.
     *
     * @param script script content.
     * @return the SHA1 value.
     * @since 6.0
     */
    suspend fun digest(script: ByteArray): String?

}

