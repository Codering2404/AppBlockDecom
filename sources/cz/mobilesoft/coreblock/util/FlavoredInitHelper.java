package cz.mobilesoft.coreblock.util;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class FlavoredInitHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlavoredInitHelper f127873a = new FlavoredInitHelper();

    private FlavoredInitHelper() {
    }

    public final void a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), null, null, new FlavoredInitHelper$initializeAnalytics$1(context, str, null), 3, null);
    }

    public final boolean b(String str) {
        return str == null || StringsKt.p0(str) || Intrinsics.areEqual(str, "com.android.vending") || Intrinsics.areEqual(str, "cz.mobilesoft.appblock") || Intrinsics.areEqual(str, "dev.firebase.appdistribution");
    }
}
