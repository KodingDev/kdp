/*
 *  KDP is a modular and customizable Discord command processing library.
 *  Copyright (C) 2020-2021 Cubxity.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published
 *  by the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package dev.cubxity.kdp.pipeline

import kotlinx.coroutines.CoroutineScope

/**
 * Represents running execution of a [pipeline][Pipeline].
 */
interface PipelineContext<TSubject : Any, TContext : Any> : CoroutineScope {
    /**
     * Object representing context in which [pipeline][Pipeline] executes.
     */
    val context: TContext

    /**
     * Subject of this [pipeline][Pipeline] execution that goes along the [pipeline][Pipeline].
     */
    val subject: TSubject

    /**
     * Finishes the current [pipeline][Pipeline] execution.
     */
    fun finish()

    /**
     * Continues execution of the [pipeline][Pipeline] with the given [subject][TSubject].
     */
    suspend fun proceedWith(subject: TSubject): TSubject

    /**
     * Continues execution of the [pipeline][Pipeline] with the same [subject][TSubject].
     */
    suspend fun proceed(): TSubject
}

internal interface PipelineExecutor<TSubject> {
    /**
     * Start pipeline execution or fail if already running and not yet completed.
     * It should not be invoked concurrently.
     */
    suspend fun execute(initial: TSubject): TSubject
}