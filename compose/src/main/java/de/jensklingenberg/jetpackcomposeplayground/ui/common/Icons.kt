/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.ui.material.icons

import androidx.ui.graphics.Color
import androidx.ui.graphics.SolidColor
import androidx.ui.graphics.StrokeCap
import androidx.ui.graphics.StrokeJoin
import androidx.ui.graphics.vector.PathBuilder
import androidx.ui.graphics.vector.VectorAsset
import androidx.ui.graphics.vector.VectorAssetBuilder
import androidx.ui.graphics.vector.path
import androidx.ui.unit.dp

/**
 * Entry point for using [Material Icons](https://material.io/resources/icons) in Compose.
 *
 * There are five distinct icon themes: [Filled], [Outlined], [Rounded], [TwoTone], and [Sharp].
 * Each theme contains the same icons, but with a distinct visual style. You should typically
 * choose one theme and use it across your application for consistency. For example, you may want
 * to use a property or a typealias to refer to a specific theme, so it can be accessed in a
 * semantically meaningful way from inside other composables.
 *
 * @sample androidx.ui.material.icons.samples.AppIcons
 *
 * Icons maintain the same names defined by Material, but with their snake_case name converted to
 * PascalCase. For example: add_alarm becomes AddAlarm.
 *
 * Note: Icons that start with a number, such as `360`, are prefixed with a '_', becoming '_360'.
 *
 * Icons are represented as [androidx.ui.graphics.vector.VectorAsset]s and hence can be drawn by
 * simply using [androidx.ui.graphics.vector.DrawVector].
 *
 * @sample androidx.ui.material.icons.samples.DrawIcon
 */
object Icons {
    /**
     * [Filled icons](https://material.io/resources/icons/?style=baseline) (previously the only
     * available theme, also known as the baseline theme) are the default icon theme. You can
     * also use [Default] as an alias for these icons.
     */
    object Filled

    /**
     * [Outlined icons](https://material.io/resources/icons/?style=outline) make use of a thin
     * stroke and empty space inside for a lighter appearance.
     */
    object Outlined

    /**
     * [Rounded icons](https://material.io/resources/icons/?style=round) use a corner radius that
     * pairs well with brands that use heavier typography, curved logos, or circular elements to
     * express their style.
     */
    object Rounded

    /**
     * [Two-Tone icons](https://material.io/resources/icons/?style=twotone) display corners with
     * straight edges, for a crisp style that remains legible even at smaller scales. These
     * rectangular shapes can support brand styles that are not well-reflected by rounded shapes.
     */
    object TwoTone

    /**
     * [Sharp icons](https://material.io/resources/icons/?style=sharp) display corners with
     * straight edges, for a crisp style that remains legible even at smaller scales. These
     * rectangular shapes can support brand styles that are not well-reflected by rounded shapes.
     */
    object Sharp

    /**
     * Alias for [Filled], the baseline icon theme.
     */
    val Default = Filled
}

/**
 * Utility delegate to construct a lazily initialized Material icon with default size information.
 * This is used by generated icons, and should not be used manually.
 *
 * @param block builder lambda to add paths to this vector asset
 */
fun lazyMaterialIcon(
    block: VectorAssetBuilder.() -> VectorAssetBuilder
): Lazy<VectorAsset> = lazy(LazyThreadSafetyMode.NONE) {
    VectorAssetBuilder(
        defaultWidth = MaterialIconDimension.dp,
        defaultHeight = MaterialIconDimension.dp,
        viewportWidth = MaterialIconDimension,
        viewportHeight = MaterialIconDimension
    ).block().build()
}

/**
 * Adds a vector path to this icon with sane Material defaults.
 *
 * @param fillAlpha fill alpha for this path
 * @param strokeAlpha stroke alpha for this path
 * @param pathBuilder builder lambda to add commands to this path
 */
fun VectorAssetBuilder.materialPath(
    fillAlpha: Float = 1f,
    strokeAlpha: Float = 1f,
    pathBuilder: PathBuilder.() -> Unit
) =
    // TODO: b/146213225
    // Some of these defaults are already set when parsing from XML, but do not currently exist
    // when added programmatically. We should unify these and simplify them where possible.
    path(
        fill = SolidColor(Color.Black),
        fillAlpha = fillAlpha,
        stroke = null,
        strokeAlpha = strokeAlpha,
        strokeLineWidth = 1f,
        strokeLineCap = StrokeCap.butt,
        strokeLineJoin = StrokeJoin.bevel,
        strokeLineMiter = 1f,
        pathBuilder = pathBuilder
    )

// All Material icons (currently) are 24dp by 24dp, with a viewport size of 24 by 24.
private const val MaterialIconDimension = 24f
