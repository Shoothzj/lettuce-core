/*
 * Copyright 2017-2021 the original author or authors.
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
package io.lettuce.core.api.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import io.lettuce.core.ScanArgs;
import io.lettuce.core.ScanCursor;
import io.lettuce.core.StreamScanCursor;
import io.lettuce.core.ValueScanCursor;
import io.lettuce.core.output.ValueStreamingChannel;

/**
 * Reactive executed commands for Sets.
 *
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mark Paluch
 * @since 4.0
 * @generated by io.lettuce.apigenerator.CreateReactiveApi
 */
public interface RedisSetReactiveCommands<K, V> {

    /**
     * Add one or more members to a set.
     *
     * @param key the key.
     * @param members the member type: value.
     * @return Long integer-reply the number of elements that were added to the set, not including all the elements already
     *         present into the set.
     */
    Mono<Long> sadd(K key, V... members);

    /**
     * Get the number of members in a set.
     *
     * @param key the key.
     * @return Long integer-reply the cardinality (number of elements) of the set, or {@code false} if {@code key} does not
     *         exist.
     */
    Mono<Long> scard(K key);

    /**
     * Subtract multiple sets.
     *
     * @param keys the key.
     * @return V array-reply list with members of the resulting set.
     */
    Flux<V> sdiff(K... keys);

    /**
     * Subtract multiple sets.
     *
     * @param channel the channel.
     * @param keys the keys.
     * @return Long count of members of the resulting set.
     * @deprecated since 6.0 in favor of consuming large results through the {@link org.reactivestreams.Publisher} returned by
     *             {@link #sdiff}.
     */
    @Deprecated
    Mono<Long> sdiff(ValueStreamingChannel<V> channel, K... keys);

    /**
     * Subtract multiple sets and store the resulting set in a key.
     *
     * @param destination the destination type: key.
     * @param keys the key.
     * @return Long integer-reply the number of elements in the resulting set.
     */
    Mono<Long> sdiffstore(K destination, K... keys);

    /**
     * Intersect multiple sets.
     *
     * @param keys the key.
     * @return V array-reply list with members of the resulting set.
     */
    Flux<V> sinter(K... keys);

    /**
     * Intersect multiple sets.
     *
     * @param channel the channel.
     * @param keys the keys.
     * @return Long count of members of the resulting set.
     * @deprecated since 6.0 in favor of consuming large results through the {@link org.reactivestreams.Publisher} returned by
     *             {@link #sinter}.
     */
    @Deprecated
    Mono<Long> sinter(ValueStreamingChannel<V> channel, K... keys);

    /**
     * Intersect multiple sets and store the resulting set in a key.
     *
     * @param destination the destination type: key.
     * @param keys the key.
     * @return Long integer-reply the number of elements in the resulting set.
     */
    Mono<Long> sinterstore(K destination, K... keys);

    /**
     * Determine if a given value is a member of a set.
     *
     * @param key the key.
     * @param member the member type: value.
     * @return Boolean integer-reply specifically:
     *
     *         {@code true} if the element is a member of the set. {@code false} if the element is not a member of the set, or
     *         if {@code key} does not exist.
     */
    Mono<Boolean> sismember(K key, V member);

    /**
     * Move a member from one set to another.
     *
     * @param source the source key.
     * @param destination the destination type: key.
     * @param member the member type: value.
     * @return Boolean integer-reply specifically:
     *
     *         {@code true} if the element is moved. {@code false} if the element is not a member of {@code source} and no
     *         operation was performed.
     */
    Mono<Boolean> smove(K source, K destination, V member);

    /**
     * Get all the members in a set.
     *
     * @param key the key.
     * @return V array-reply all elements of the set.
     */
    Flux<V> smembers(K key);

    /**
     * Get all the members in a set.
     *
     * @param channel the channel.
     * @param key the keys.
     * @return Long count of members of the resulting set.
     * @deprecated since 6.0 in favor of consuming large results through the {@link org.reactivestreams.Publisher} returned by
     *             {@link #smembers}.
     */
    @Deprecated
    Mono<Long> smembers(ValueStreamingChannel<V> channel, K key);

    /**
     * Remove and return a random member from a set.
     *
     * @param key the key.
     * @return V bulk-string-reply the removed element, or {@code null} when {@code key} does not exist.
     */
    Mono<V> spop(K key);

    /**
     * Remove and return one or multiple random members from a set.
     *
     * @param key the key.
     * @param count number of members to pop.
     * @return V bulk-string-reply the removed element, or {@code null} when {@code key} does not exist.
     */
    Flux<V> spop(K key, long count);

    /**
     * Get one random member from a set.
     *
     * @param key the key.
     * @return V bulk-string-reply without the additional {@code count} argument the command returns a Bulk Reply with the
     *         randomly selected element, or {@code null} when {@code key} does not exist.
     */
    Mono<V> srandmember(K key);

    /**
     * Get one or multiple random members from a set.
     *
     * @param key the key.
     * @param count the count type: long.
     * @return V bulk-string-reply without the additional {@code count} argument the command returns a Bulk Reply with the
     *         randomly selected element, or {@code null} when {@code key} does not exist.
     */
    Flux<V> srandmember(K key, long count);

    /**
     * Get one or multiple random members from a set.
     *
     * @param channel streaming channel that receives a call for every value.
     * @param key the key.
     * @param count the count.
     * @return Long count of members of the resulting set.
     * @deprecated since 6.0 in favor of consuming large results through the {@link org.reactivestreams.Publisher} returned by
     *             {@link #srandmember}.
     */
    @Deprecated
    Mono<Long> srandmember(ValueStreamingChannel<V> channel, K key, long count);

    /**
     * Remove one or more members from a set.
     *
     * @param key the key.
     * @param members the member type: value.
     * @return Long integer-reply the number of members that were removed from the set, not including non existing members.
     */
    Mono<Long> srem(K key, V... members);

    /**
     * Add multiple sets.
     *
     * @param keys the key.
     * @return V array-reply list with members of the resulting set.
     */
    Flux<V> sunion(K... keys);

    /**
     * Add multiple sets.
     *
     * @param channel streaming channel that receives a call for every value.
     * @param keys the keys.
     * @return Long count of members of the resulting set.
     * @deprecated since 6.0 in favor of consuming large results through the {@link org.reactivestreams.Publisher} returned by
     *             {@link #sunion}.
     */
    @Deprecated
    Mono<Long> sunion(ValueStreamingChannel<V> channel, K... keys);

    /**
     * Add multiple sets and store the resulting set in a key.
     *
     * @param destination the destination type: key.
     * @param keys the key.
     * @return Long integer-reply the number of elements in the resulting set.
     */
    Mono<Long> sunionstore(K destination, K... keys);

    /**
     * Incrementally iterate Set elements.
     *
     * @param key the key.
     * @return ValueScanCursor&lt;V&gt; scan cursor.
     */
    Mono<ValueScanCursor<V>> sscan(K key);

    /**
     * Incrementally iterate Set elements.
     *
     * @param key the key.
     * @param scanArgs scan arguments.
     * @return ValueScanCursor&lt;V&gt; scan cursor.
     */
    Mono<ValueScanCursor<V>> sscan(K key, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     *
     * @param key the key.
     * @param scanCursor cursor to resume from a previous scan, must not be {@code null}.
     * @param scanArgs scan arguments.
     * @return ValueScanCursor&lt;V&gt; scan cursor.
     */
    Mono<ValueScanCursor<V>> sscan(K key, ScanCursor scanCursor, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     *
     * @param key the key.
     * @param scanCursor cursor to resume from a previous scan, must not be {@code null}.
     * @return ValueScanCursor&lt;V&gt; scan cursor.
     */
    Mono<ValueScanCursor<V>> sscan(K key, ScanCursor scanCursor);

    /**
     * Incrementally iterate Set elements.
     *
     * @param channel streaming channel that receives a call for every value.
     * @param key the key.
     * @return StreamScanCursor scan cursor.
     * @deprecated since 6.0 in favor of consuming large results through the {@link org.reactivestreams.Publisher} returned by
     *             {@link #sscan}.
     */
    @Deprecated
    Mono<StreamScanCursor> sscan(ValueStreamingChannel<V> channel, K key);

    /**
     * Incrementally iterate Set elements.
     *
     * @param channel streaming channel that receives a call for every value.
     * @param key the key.
     * @param scanArgs scan arguments.
     * @return StreamScanCursor scan cursor.
     * @deprecated since 6.0 in favor of consuming large results through the {@link org.reactivestreams.Publisher} returned by
     *             {@link #sscan}.
     */
    @Deprecated
    Mono<StreamScanCursor> sscan(ValueStreamingChannel<V> channel, K key, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     *
     * @param channel streaming channel that receives a call for every value.
     * @param key the key.
     * @param scanCursor cursor to resume from a previous scan, must not be {@code null}.
     * @param scanArgs scan arguments.
     * @return StreamScanCursor scan cursor.
     * @deprecated since 6.0 in favor of consuming large results through the {@link org.reactivestreams.Publisher} returned by
     *             {@link #sscan}.
     */
    @Deprecated
    Mono<StreamScanCursor> sscan(ValueStreamingChannel<V> channel, K key, ScanCursor scanCursor, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     *
     * @param channel streaming channel that receives a call for every value.
     * @param key the key.
     * @param scanCursor cursor to resume from a previous scan, must not be {@code null}.
     * @return StreamScanCursor scan cursor.
     * @deprecated since 6.0 in favor of consuming large results through the {@link org.reactivestreams.Publisher} returned by
     *             {@link #sscan}.
     */
    @Deprecated
    Mono<StreamScanCursor> sscan(ValueStreamingChannel<V> channel, K key, ScanCursor scanCursor);
}
