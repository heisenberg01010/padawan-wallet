/*
 * Copyright 2020-2022 thunderbiscuit and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the ./LICENSE file.
 */

package com.goldenraven.padawanwallet.data.chapters

import com.goldenraven.padawanwallet.R

data class ChapterElement(val elementType: ElementType, val resourceId: Int)

typealias Page = List<ChapterElement>

enum class ElementType {
    TITLE,
    SUBTITLE,
    BODY,
    RESOURCE,
}

val chapter1: List<Page> = listOf(
    listOf(
        ChapterElement(ElementType.BODY, R.string.C1_tagline)
    ),
    listOf(
        ChapterElement(ElementType.TITLE, R.string.C1_title),
        ChapterElement(ElementType.BODY, R.string.t1_p1),
        ChapterElement(ElementType.BODY, R.string.t1_p2),
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t1_h2),
        ChapterElement(ElementType.BODY, R.string.t1_p3),
        ChapterElement(ElementType.BODY, R.string.t1_p4),
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t1_h3),
        ChapterElement(ElementType.BODY, R.string.t1_p5),
        ChapterElement(ElementType.BODY, R.string.t1_p6),
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t1_h4),
        ChapterElement(ElementType.BODY, R.string.t1_p7),
        ChapterElement(ElementType.BODY, R.string.t1_p8),
        ChapterElement(ElementType.BODY, R.string.t1_p9),
    ),
)

val chapter2: List<Page> = listOf(
    listOf(
        ChapterElement(ElementType.BODY, R.string.C2_tagline)
    ),
    listOf(
        ChapterElement(ElementType.TITLE, R.string.C2_title),
        ChapterElement(ElementType.BODY, R.string.t2_p1),
        ChapterElement(ElementType.BODY, R.string.t2_p2),
        ChapterElement(ElementType.BODY, R.string.t2_p3),
        ChapterElement(ElementType.RESOURCE, R.drawable.btc_address),
        ChapterElement(ElementType.BODY, R.string.t2_p4),
        ChapterElement(ElementType.BODY, R.string.t2_p5),
        ChapterElement(ElementType.RESOURCE, R.drawable.qr_code),
        ChapterElement(ElementType.BODY, R.string.t2_p6),
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t2_h1),
        ChapterElement(ElementType.BODY, R.string.t2_p7),
        ChapterElement(ElementType.BODY, R.string.t2_p8),
        ChapterElement(ElementType.BODY, R.string.t2_p9),
        ChapterElement(ElementType.BODY, R.string.t2_p10),
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t2_h2),
        ChapterElement(ElementType.BODY, R.string.t2_p11),
        ChapterElement(ElementType.BODY, R.string.t2_p12),
        ChapterElement(ElementType.BODY, R.string.t2_p13),
    ),
)

val chapter3: List<Page> = listOf(
    listOf(
        ChapterElement(ElementType.BODY, R.string.C3_tagline)
    ),
    listOf(
        ChapterElement(ElementType.TITLE, R.string.C3_title),
        ChapterElement(ElementType.BODY, R.string.t3_p1),
        ChapterElement(ElementType.BODY, R.string.t3_p2),
        ChapterElement(ElementType.RESOURCE, R.drawable.placeholder_image),
    ),
)

val chapter4: List<Page> = listOf(
    listOf(
        ChapterElement(ElementType.BODY, R.string.C4_tagline)
    ),
    listOf(
        ChapterElement(ElementType.TITLE, R.string.C4_title),
        ChapterElement(ElementType.BODY, R.string.t4_p1),
        ChapterElement(ElementType.BODY, R.string.t4_p2),
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t4_h1),
        ChapterElement(ElementType.BODY, R.string.t4_p3),
        ChapterElement(ElementType.BODY, R.string.t4_p4),
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t4_h2),
        ChapterElement(ElementType.BODY, R.string.t4_p5),
        ChapterElement(ElementType.BODY, R.string.t4_p6),
    ),
)

val chapter5: List<Page> = listOf(
    listOf(
        ChapterElement(ElementType.BODY, R.string.C5_tagline)
    ),
    listOf(
        ChapterElement(ElementType.TITLE, R.string.C5_title),
        ChapterElement(ElementType.BODY, R.string.t5_p1),
        ChapterElement(ElementType.BODY, R.string.t5_p2),
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t5_h1),
        ChapterElement(ElementType.BODY, R.string.t5_p3),
        ChapterElement(ElementType.BODY, R.string.t5_p4),
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t5_h2),
        ChapterElement(ElementType.BODY, R.string.t5_p5),
    ),
)

val chapter6: List<Page> = listOf(
    listOf(
        ChapterElement(ElementType.BODY, R.string.C6_tagline)
    ),
    listOf(
        ChapterElement(ElementType.TITLE, R.string.C6_title),
        ChapterElement(ElementType.BODY, R.string.t6_p1),
        ChapterElement(ElementType.BODY, R.string.t6_p2),
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t6_h1),
        ChapterElement(ElementType.BODY, R.string.t6_p3),
        ChapterElement(ElementType.BODY, R.string.t6_p4),
        ChapterElement(ElementType.RESOURCE, R.drawable.placeholder_image),
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t6_h2),
        ChapterElement(ElementType.BODY, R.string.t6_p5),
        ChapterElement(ElementType.RESOURCE, R.drawable.placeholder_image),
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t6_h3),
        ChapterElement(ElementType.BODY, R.string.t6_p6),
        ChapterElement(ElementType.BODY, R.string.t6_p7),
        ChapterElement(ElementType.BODY, R.string.t6_p8),
        ChapterElement(ElementType.BODY, R.string.t6_p9),
        ChapterElement(ElementType.BODY, R.string.t6_p10),
    ),
)

val chapter7: List<Page> = listOf(
    listOf(
        ChapterElement(ElementType.BODY, R.string.C7_tagline)
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.C7_title),
        ChapterElement(ElementType.BODY, R.string.C7_p1),
        ChapterElement(ElementType.BODY, R.string.C7_p2),
        ChapterElement(ElementType.BODY, R.string.C7_p3),
        ChapterElement(ElementType.BODY, R.string.C7_p4),
    ),
    listOf(
        ChapterElement(ElementType.TITLE, R.string.C7_h1),
        ChapterElement(ElementType.BODY, R.string.C7_p5),
        ChapterElement(ElementType.RESOURCE, R.drawable.placeholder_image),
        ChapterElement(ElementType.BODY, R.string.C7_p6),
        ChapterElement(ElementType.BODY, R.string.C7_p7),
    ),
)

val chapter8: List<Page> = listOf(
    listOf(
        ChapterElement(ElementType.BODY, R.string.C8_tagline)
    ),
    listOf(
        ChapterElement(ElementType.TITLE, R.string.C8_title),
        ChapterElement(ElementType.BODY, R.string.C8_p1),
        ChapterElement(ElementType.BODY, R.string.C8_p2),
        ChapterElement(ElementType.RESOURCE, R.drawable.placeholder_image),
        ChapterElement(ElementType.BODY, R.string.C8_p3),
        ChapterElement(ElementType.BODY, R.string.C8_p4),
        ChapterElement(ElementType.BODY, R.string.C8_p5),
    ),
    listOf(
        ChapterElement(ElementType.TITLE, R.string.C8_h1),
        ChapterElement(ElementType.BODY, R.string.C8_p6),
        ChapterElement(ElementType.BODY, R.string.C8_p7),
        ChapterElement(ElementType.BODY, R.string.C8_p8),
    ),
)

val chapter9: List<Page> = listOf(
    listOf(
        ChapterElement(ElementType.BODY, R.string.C9_tagline)
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t9_h1),
        ChapterElement(ElementType.BODY, R.string.t9_p1),
        ChapterElement(ElementType.BODY, R.string.t9_p2),
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t9_h2),
        ChapterElement(ElementType.BODY, R.string.t9_p3),
        ChapterElement(ElementType.BODY, R.string.t9_p4),
        ChapterElement(ElementType.BODY, R.string.t9_p5),
    ),
    listOf(
        ChapterElement(ElementType.SUBTITLE, R.string.t9_h3),
        ChapterElement(ElementType.BODY, R.string.t9_p6),
        ChapterElement(ElementType.BODY, R.string.t9_p7),
        ChapterElement(ElementType.BODY, R.string.t9_p8),
        ChapterElement(ElementType.BODY, R.string.t9_p9),
        ChapterElement(ElementType.BODY, R.string.t9_p10),
        ChapterElement(ElementType.BODY, R.string.t9_p11),
    ),
)
