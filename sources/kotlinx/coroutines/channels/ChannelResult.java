package kotlinx.coroutines.channels;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@JvmInline
public final class ChannelResult<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f141130b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Failed f141131c = new Failed();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f141132a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Closed extends Failed {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f141133a;

        public Closed(Throwable th) {
            this.f141133a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Closed) && Intrinsics.areEqual(this.f141133a, ((Closed) obj).f141133a);
        }

        public int hashCode() {
            Throwable th = this.f141133a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult.Failed
        public String toString() {
            return "Closed(" + this.f141133a + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Object a(Throwable th) {
            return ChannelResult.c(new Closed(th));
        }

        public final Object b() {
            return ChannelResult.c(ChannelResult.f141131c);
        }

        public final Object c(Object obj) {
            return ChannelResult.c(obj);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class Failed {
        public String toString() {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED;
        }
    }

    private /* synthetic */ ChannelResult(Object obj) {
        this.f141132a = obj;
    }

    public static final /* synthetic */ ChannelResult b(Object obj) {
        return new ChannelResult(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof ChannelResult) && Intrinsics.areEqual(obj, ((ChannelResult) obj2).m());
    }

    public static final Throwable e(Object obj) {
        Closed closed = obj instanceof Closed ? (Closed) obj : null;
        if (closed != null) {
            return closed.f141133a;
        }
        return null;
    }

    public static final Object f(Object obj) {
        if (obj instanceof Failed) {
            return null;
        }
        return obj;
    }

    public static final Object g(Object obj) throws Throwable {
        Throwable th;
        if (!(obj instanceof Failed)) {
            return obj;
        }
        if ((obj instanceof Closed) && (th = ((Closed) obj).f141133a) != null) {
            throw th;
        }
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + obj).toString());
    }

    public static int h(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean i(Object obj) {
        return obj instanceof Closed;
    }

    public static final boolean j(Object obj) {
        return obj instanceof Failed;
    }

    public static final boolean k(Object obj) {
        return !(obj instanceof Failed);
    }

    public static String l(Object obj) {
        if (obj instanceof Closed) {
            return ((Closed) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f141132a, obj);
    }

    public int hashCode() {
        return h(this.f141132a);
    }

    public final /* synthetic */ Object m() {
        return this.f141132a;
    }

    public String toString() {
        return l(this.f141132a);
    }

    public static Object c(Object obj) {
        return obj;
    }
}
