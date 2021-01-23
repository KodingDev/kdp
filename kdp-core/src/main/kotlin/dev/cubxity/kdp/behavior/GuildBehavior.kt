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

package dev.cubxity.kdp.behavior

import dev.cubxity.kdp.engine.KDPEngine
import dev.cubxity.kdp.entity.*
import dev.cubxity.kdp.entity.channel.GuildChannel
import dev.cubxity.kdp.exception.guildNotFound
import dev.cubxity.kdp.exception.memberNotFound
import dev.cubxity.kdp.exception.roleNotFound
import kotlinx.coroutines.flow.Flow

interface GuildBehavior<TEngine : KDPEngine<TEngine>> : Entity<TEngine> {
    val members: Flow<Member<TEngine>>

    val channels: Flow<GuildChannel<TEngine>>

    val roles: Flow<Role<TEngine>>

    val voiceStates: Flow<VoiceState<TEngine>>

    val emojis: Flow<Emoji<TEngine>>

    suspend fun asGuild(): Guild<TEngine> =
        asGuildOrNull() ?: guildNotFound(id)

    suspend fun asGuildOrNull(): Guild<TEngine>?

    suspend fun getMember(userId: Snowflake): Member<TEngine> =
        getMemberOrNull(userId) ?: memberNotFound(id, userId)

    suspend fun getMemberOrNull(userId: Snowflake): Member<TEngine>?

    suspend fun getRole(roleId: Snowflake): Role<TEngine> =
        getRoleOrNull(roleId) ?: roleNotFound(id, roleId)

    suspend fun getRoleOrNull(roleId: Snowflake): Role<TEngine>?
}