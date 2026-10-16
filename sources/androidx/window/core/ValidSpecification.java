package androidx.window.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class ValidSpecification<T> extends SpecificationComputer<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f54142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f54143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VerificationMode f54144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Logger f54145e;

    public ValidSpecification(Object value, String tag, VerificationMode verificationMode, Logger logger) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(verificationMode, "verificationMode");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f54142b = value;
        this.f54143c = tag;
        this.f54144d = verificationMode;
        this.f54145e = logger;
    }

    @Override // androidx.window.core.SpecificationComputer
    public Object a() {
        return this.f54142b;
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer c(String message, Function1 condition) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(condition, "condition");
        return ((Boolean) condition.invoke(this.f54142b)).booleanValue() ? this : new FailedSpecification(this.f54142b, this.f54143c, message, this.f54145e, this.f54144d);
    }
}
