package cz.mobilesoft.coreblock.util;

import com.facebook.internal.Utility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.util.typeconverter.DateZonedIsoJsonTypeAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

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
public final class JSONHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JSONHelper f127888a = new JSONHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f127889b = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.p
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return JSONHelper.c();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f127890c = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.q
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return JSONHelper.d();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f127891d = 8;

    private JSONHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson c() {
        return new Gson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson d() {
        return new GsonBuilder().c(Date.class, new DateZonedIsoJsonTypeAdapter()).b();
    }

    public final Gson e() {
        return (Gson) f127889b.getValue();
    }

    public final Gson f() {
        Object value = f127890c.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Gson) value;
    }

    public final String g(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        try {
            InputStream inputStreamOpen = LockieApplication.g().getAssets().open(fileName);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Charsets.f140510b), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            try {
                String strH = TextStreamsKt.h(bufferedReader);
                CloseableKt.a(bufferedReader, null);
                return strH;
            } finally {
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
