package org.koin.mp;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.context.KoinContext;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.logger.PrintLogger;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class KoinPlatformTools {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KoinPlatformTools f146106a = new KoinPlatformTools();

    private KoinPlatformTools() {
    }

    public final KoinContext a() {
        return GlobalContext.f145907a;
    }

    public final LazyThreadSafetyMode b() {
        return LazyThreadSafetyMode.f139761a;
    }

    public final Logger c(Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        return new PrintLogger(level);
    }

    public final String d() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        return string;
    }

    public final String e(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        String name = JvmClassMappingKt.a(kClass).getName();
        Intrinsics.checkNotNullExpressionValue(name, "kClass.java.name");
        return name;
    }

    public final String f(Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        StringBuilder sb = new StringBuilder();
        sb.append(e3);
        sb.append("\n\t");
        StackTraceElement[] stackTrace = e3.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "it.className");
            if (StringsKt.a0(className, "sun.reflect", false, 2, null)) {
                break;
            }
            arrayList.add(stackTraceElement);
        }
        sb.append(CollectionsKt.joinToString$default(arrayList, "\n\t", null, null, 0, null, null, 62, null));
        return sb.toString();
    }

    public final Map g() {
        return new ConcurrentHashMap();
    }

    public final Object h(Object lock, Function0 block) {
        Object objInvoke;
        Intrinsics.checkNotNullParameter(lock, "lock");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (lock) {
            objInvoke = block.invoke();
        }
        return objInvoke;
    }
}
