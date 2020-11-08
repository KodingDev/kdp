/*
 *  KDP is a modular and customizable Discord command processing library.
 *  Copyright (C) 2020 Cubxity.
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

/**
 * Represents an image, such as [avatar][User.Avatar] and [icon][Guild.Icon].
 */
interface ImageHolder {
    val id: String?

    operator fun get(format: ImageFormat): String
}

inline val ImageHolder.isAnimated: Boolean
    get() = id?.startsWith("a_") == true

inline val ImageHolder.url: String
    get() = if (isAnimated) this[ImageFormat.GIF] else this[ImageFormat.PNG]

enum class ImageFormat(val extension: String) {
    JPEG("jpeg"),
    PNG("png"),
    WEBP("webp"),
    GIF("gif")
}