package androidx.window.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class FailedSpecification<T> extends SpecificationComputer<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f54129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f54130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f54131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Logger f54132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final VerificationMode f54133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WindowStrictModeException f54134g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f54135a;

        static {
            int[] iArr = new int[VerificationMode.values().length];
            try {
                iArr[VerificationMode.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VerificationMode.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VerificationMode.QUIET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f54135a = iArr;
        }
    }

    public FailedSpecification(Object value, String tag, String message, Logger logger, VerificationMode verificationMode) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(verificationMode, "verificationMode");
        this.f54129b = value;
        this.f54130c = tag;
        this.f54131d = message;
        this.f54132e = logger;
        this.f54133f = verificationMode;
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(b(value, message));
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
        windowStrictModeException.setStackTrace((StackTraceElement[]) ArraysKt.drop(stackTrace, 2).toArray(new StackTraceElement[0]));
        this.f54134g = windowStrictModeException;
    }

    @Override // androidx.window.core.SpecificationComputer
    public Object a() throws WindowStrictModeException {
        int i3 = WhenMappings.f54135a[this.f54133f.ordinal()];
        if (i3 == 1) {
            throw this.f54134g;
        }
        if (i3 == 2) {
            this.f54132e.a(this.f54130c, b(this.f54129b, this.f54131d));
            return null;
        }
        if (i3 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer c(String message, Function1 condition) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(condition, "condition");
        return this;
    }
}
