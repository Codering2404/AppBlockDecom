package androidx.navigation;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class NavTypeKt {
    public static final NavType a(String str) {
        NavType navType = NavType.f48957d;
        if (Intrinsics.areEqual(navType.b(), str)) {
            return navType;
        }
        NavType navType2 = NavType.f48959f;
        if (Intrinsics.areEqual(navType2.b(), str)) {
            return navType2;
        }
        NavType navType3 = NavType.f48960g;
        if (Intrinsics.areEqual(navType3.b(), str)) {
            return navType3;
        }
        NavType navType4 = NavType.f48961h;
        if (Intrinsics.areEqual(navType4.b(), str)) {
            return navType4;
        }
        NavType navType5 = NavType.f48962i;
        if (Intrinsics.areEqual(navType5.b(), str)) {
            return navType5;
        }
        NavType navType6 = NavType.f48963j;
        if (Intrinsics.areEqual(navType6.b(), str)) {
            return navType6;
        }
        NavType navType7 = NavType.f48967n;
        if (Intrinsics.areEqual(navType7.b(), str)) {
            return navType7;
        }
        NavType navType8 = NavType.f48968o;
        if (Intrinsics.areEqual(navType8.b(), str)) {
            return navType8;
        }
        NavType navType9 = NavType.f48969p;
        if (Intrinsics.areEqual(navType9.b(), str)) {
            return navType9;
        }
        NavType navType10 = NavType.f48970q;
        if (Intrinsics.areEqual(navType10.b(), str)) {
            return navType10;
        }
        NavType navType11 = NavType.f48971r;
        if (Intrinsics.areEqual(navType11.b(), str)) {
            return navType11;
        }
        NavType navType12 = NavType.f48972s;
        if (Intrinsics.areEqual(navType12.b(), str)) {
            return navType12;
        }
        NavType navType13 = NavType.f48964k;
        if (Intrinsics.areEqual(navType13.b(), str)) {
            return navType13;
        }
        NavType navType14 = NavType.f48965l;
        if (Intrinsics.areEqual(navType14.b(), str)) {
            return navType14;
        }
        NavType navType15 = NavType.f48966m;
        if (Intrinsics.areEqual(navType15.b(), str)) {
            return navType15;
        }
        return null;
    }

    public static final NavType b(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            try {
                try {
                    try {
                        NavType navType = NavType.f48957d;
                        navType.l(value);
                        Intrinsics.checkNotNull(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                        return navType;
                    } catch (IllegalArgumentException unused) {
                        NavType navType2 = NavType.f48967n;
                        navType2.l(value);
                        Intrinsics.checkNotNull(navType2, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                        return navType2;
                    }
                } catch (IllegalArgumentException unused2) {
                    NavType navType3 = NavType.f48961h;
                    navType3.l(value);
                    Intrinsics.checkNotNull(navType3, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                    return navType3;
                }
            } catch (IllegalArgumentException unused3) {
                NavType navType4 = NavType.f48970q;
                Intrinsics.checkNotNull(navType4, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
                return navType4;
            }
        } catch (IllegalArgumentException unused4) {
            NavType navType5 = NavType.f48964k;
            navType5.l(value);
            Intrinsics.checkNotNull(navType5, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
            return navType5;
        }
    }

    public static final NavType c(Object obj) {
        if (obj instanceof Integer) {
            NavType navType = NavType.f48957d;
            Intrinsics.checkNotNull(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
            return navType;
        }
        if (obj instanceof int[]) {
            NavType navType2 = NavType.f48959f;
            Intrinsics.checkNotNull(navType2, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
            return navType2;
        }
        if (obj instanceof Long) {
            NavType navType3 = NavType.f48961h;
            Intrinsics.checkNotNull(navType3, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
            return navType3;
        }
        if (obj instanceof long[]) {
            NavType navType4 = NavType.f48962i;
            Intrinsics.checkNotNull(navType4, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
            return navType4;
        }
        if (obj instanceof Float) {
            NavType navType5 = NavType.f48964k;
            Intrinsics.checkNotNull(navType5, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
            return navType5;
        }
        if (obj instanceof float[]) {
            NavType navType6 = NavType.f48965l;
            Intrinsics.checkNotNull(navType6, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
            return navType6;
        }
        if (obj instanceof Boolean) {
            NavType navType7 = NavType.f48967n;
            Intrinsics.checkNotNull(navType7, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
            return navType7;
        }
        if (obj instanceof boolean[]) {
            NavType navType8 = NavType.f48968o;
            Intrinsics.checkNotNull(navType8, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
            return navType8;
        }
        if (!(obj instanceof String) && obj != null) {
            return null;
        }
        NavType navType9 = NavType.f48970q;
        Intrinsics.checkNotNull(navType9, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any>");
        return navType9;
    }

    public static final Object d(NavType navType, Bundle bundle, String key, String value) {
        Intrinsics.checkNotNullParameter(navType, "<this>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Object objL = navType.l(value);
        navType.h(bundle, key, objL);
        return objL;
    }

    public static final Object e(NavType navType, Bundle bundle, String key, String str, Object obj) {
        Intrinsics.checkNotNullParameter(navType, "<this>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!SavedStateReader.b(SavedStateReader.a(bundle), key)) {
            throw new IllegalArgumentException("There is no previous value in this savedState.");
        }
        if (str == null) {
            return obj;
        }
        Object objG = navType.g(str, obj);
        navType.h(bundle, key, objG);
        return objG;
    }
}
