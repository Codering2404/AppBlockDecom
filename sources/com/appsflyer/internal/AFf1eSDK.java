package com.appsflyer.internal;

import android.content.Intent;
import com.appsflyer.AFLogger;
import java.util.ConcurrentModificationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFf1eSDK {
    final Intent AFInAppEventType;

    public AFf1eSDK(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        this.AFInAppEventType = intent;
    }

    public final String AFInAppEventParameterName(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Function0<String> function0 = new Function0<String>() { // from class: com.appsflyer.internal.AFf1eSDK.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: AFInAppEventType, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                return AFf1eSDK.this.AFInAppEventType.getStringExtra(str);
            }
        };
        StringBuilder sb = new StringBuilder("Error while trying to read ");
        sb.append(str);
        sb.append(" extra from intent");
        return (String) AFInAppEventType(function0, sb.toString(), null, true);
    }

    public final boolean AFInAppEventType(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Function0<Boolean> function0 = new Function0<Boolean>() { // from class: com.appsflyer.internal.AFf1eSDK.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: values, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke() {
                return Boolean.valueOf(AFf1eSDK.this.AFInAppEventType.hasExtra(str));
            }
        };
        StringBuilder sb = new StringBuilder("Error while trying to check presence of ");
        sb.append(str);
        sb.append(" extra from intent");
        Boolean bool = (Boolean) AFInAppEventType(function0, sb.toString(), Boolean.TRUE, true);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final Intent AFInAppEventType(final String str, final long j3) {
        Intrinsics.checkNotNullParameter(str, "");
        Function0<Intent> function0 = new Function0<Intent>() { // from class: com.appsflyer.internal.AFf1eSDK.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: values, reason: merged with bridge method [inline-methods] */
            public final Intent invoke() {
                return AFf1eSDK.this.AFInAppEventType.putExtra(str, j3);
            }
        };
        StringBuilder sb = new StringBuilder("Error while trying to write ");
        sb.append(str);
        sb.append(" extra to intent");
        return (Intent) AFInAppEventType(function0, sb.toString(), null, true);
    }

    public final <T> T AFInAppEventType(Function0<? extends T> function0, String str, T t2, boolean z2) {
        Object objB;
        Object objB2;
        synchronized (this.AFInAppEventType) {
            try {
                Result.Companion companion = Result.f139772b;
                objB = (T) Result.b(function0.invoke());
            } finally {
            }
            KClass[] kClassArr = {Reflection.b(ConcurrentModificationException.class), Reflection.b(ArrayIndexOutOfBoundsException.class)};
            Throwable thE = Result.e(objB);
            if (thE != null) {
                try {
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.f139772b;
                    objB2 = Result.b(ResultKt.a(th));
                }
                if (ArraysKt.contains(kClassArr, Reflection.b(thE.getClass()))) {
                    if (z2) {
                        t2 = (T) AFInAppEventType(function0, str, t2, false);
                    } else {
                        AFLogger.afErrorLog(str, thE, false, false);
                    }
                    objB2 = Result.b(t2);
                    objB = (T) objB2;
                } else {
                    throw thE;
                }
            }
            ResultKt.b(objB);
        }
        return (T) objB;
    }
}
