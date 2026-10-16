package com.revenuecat.purchases.ui.revenuecatui.utils;

import android.content.res.XmlResourceParser;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class FontFamilyXmlParser {
    public static final int $stable = 0;
    private static final String ANDROID_NAMESPACE = "http://schemas.android.com/apk/res/android";
    private static final String APP_NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private static final int DEFAULT_FONT_WEIGHT = 400;
    public static final FontFamilyXmlParser INSTANCE = new FontFamilyXmlParser();
    private static final int UNRECOGNIZED_VALUE = -1;

    private FontFamilyXmlParser() {
    }

    private final int getFontResourceId(XmlResourceParser xmlResourceParser) {
        int attributeResourceValue = xmlResourceParser.getAttributeResourceValue(APP_NAMESPACE, "font", -1);
        return attributeResourceValue == -1 ? xmlResourceParser.getAttributeResourceValue(ANDROID_NAMESPACE, "font", -1) : attributeResourceValue;
    }

    /* JADX INFO: renamed from: getFontStyle-MIvY41s, reason: not valid java name */
    private final int m1230getFontStyleMIvY41s(XmlResourceParser xmlResourceParser) {
        String attributeValue = xmlResourceParser.getAttributeValue(APP_NAMESPACE, "fontStyle");
        if (attributeValue == null) {
            attributeValue = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE, "fontStyle");
        }
        return Intrinsics.areEqual(attributeValue, "italic") ? FontStyle.f29211b.a() : FontStyle.f29211b.b();
    }

    private final int getFontWeight(XmlResourceParser xmlResourceParser) {
        int attributeIntValue = xmlResourceParser.getAttributeIntValue(APP_NAMESPACE, "fontWeight", -1);
        if (attributeIntValue == -1) {
            attributeIntValue = xmlResourceParser.getAttributeIntValue(ANDROID_NAMESPACE, "fontWeight", 400);
        }
        if (attributeIntValue == -1) {
            return 400;
        }
        return attributeIntValue;
    }

    private final ParsedFont parseFontData(XmlResourceParser xmlResourceParser) {
        int fontResourceId = getFontResourceId(xmlResourceParser);
        if (fontResourceId == -1) {
            return null;
        }
        return new ParsedFont(fontResourceId, getFontWeight(xmlResourceParser), m1230getFontStyleMIvY41s(xmlResourceParser), null);
    }

    public final FontFamily parse(XmlResourceParser parser) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(parser, "parser");
        List<ParsedFont> xmlData$revenuecatui_defaultsBc8Release = parseXmlData$revenuecatui_defaultsBc8Release(parser);
        if (xmlData$revenuecatui_defaultsBc8Release.isEmpty()) {
            return null;
        }
        List<ParsedFont> list = xmlData$revenuecatui_defaultsBc8Release;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ParsedFont parsedFont : list) {
            int iComponent1 = parsedFont.component1();
            int iComponent2 = parsedFont.component2();
            arrayList.add(FontKt.b(iComponent1, new FontWeight(iComponent2), parsedFont.m1232component3_LCdwA(), 0, 8, null));
        }
        return FontFamilyKt.b(arrayList);
    }

    public final List<ParsedFont> parseXmlData$revenuecatui_defaultsBc8Release(XmlResourceParser parser) throws XmlPullParserException, IOException {
        ParsedFont fontData;
        Intrinsics.checkNotNullParameter(parser, "parser");
        ArrayList arrayList = new ArrayList();
        int eventType = parser.getEventType();
        while (eventType != 1) {
            if (eventType == 2 && Intrinsics.areEqual(parser.getName(), "font") && (fontData = parseFontData(parser)) != null) {
                arrayList.add(fontData);
            }
            eventType = parser.next();
        }
        return arrayList;
    }
}
