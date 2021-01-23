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

package dev.cubxity.kdp.entity

import dev.cubxity.kdp.engine.KDPEngine
import kotlinx.coroutines.flow.Flow

interface Emoji<TEngine : KDPEngine<TEngine>> : Entity<TEngine> {
    val name: String?

    val roles: Flow<Role<TEngine>>

    val user: User<TEngine>?

    val isRequireColons: Boolean

    val isManaged: Boolean

    val isAnimated: Boolean

    val isAvailable: Boolean
}