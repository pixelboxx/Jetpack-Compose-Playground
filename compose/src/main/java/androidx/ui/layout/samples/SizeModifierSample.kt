/*
 * Copyright 2019 The Android Open Source Project
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

package androidx.ui.layout.samples


import androidx.compose.Composable
import androidx.ui.foundation.Box
import androidx.ui.foundation.ColoredRect
import androidx.ui.foundation.ContentGravity
import androidx.ui.graphics.Color
import androidx.ui.layout.Center
import androidx.ui.layout.LayoutAspectRatio
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.LayoutWidth
import androidx.ui.unit.dp


@Composable
fun SimpleSizeModifier() {
    Center {
        Box(LayoutSize(width = 100.dp, height = 100.dp), backgroundColor = Color.Red)
    }
}


@Composable
fun SimpleWidthModifier() {
    Center {
        Box(LayoutWidth(100.dp) + LayoutAspectRatio(1f), backgroundColor = Color.Magenta)
    }
}


@Composable
fun SimpleHeightModifier() {
    Center {
        Box(LayoutHeight(100.dp) + LayoutAspectRatio(1f), backgroundColor = Color.Blue)
    }
}


@Composable
fun SimpleFillWidthModifier() {
    Box(LayoutWidth.Fill, backgroundColor = Color.Red, gravity = ContentGravity.Center) {
        ColoredRect(color = Color.Magenta, width = 100.dp, height = 100.dp)
    }
}


@Composable
fun SimpleFillHeightModifier() {
    Box(LayoutHeight.Fill, backgroundColor = Color.Red, gravity = ContentGravity.Center) {
        ColoredRect(color = Color.Magenta, width = 100.dp, height = 100.dp)
    }
}


@Composable
fun SimpleFillModifier() {
    Box(LayoutSize.Fill, backgroundColor = Color.Red, gravity = ContentGravity.Center) {
        ColoredRect(color = Color.Magenta, width = 100.dp, height = 100.dp)
    }
}
