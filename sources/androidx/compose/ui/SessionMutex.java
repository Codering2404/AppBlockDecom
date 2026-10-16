package androidx.compose.ui;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

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
@JvmInline
public final class SessionMutex<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f25178a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Session<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Job f25179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f25180b;

        public Session(Job job, Object obj) {
            this.f25179a = job;
            this.f25180b = obj;
        }

        public final Job a() {
            return this.f25179a;
        }

        public final Object b() {
            return this.f25180b;
        }
    }

    public static AtomicReference a() {
        return b(new AtomicReference(null));
    }

    public static boolean c(AtomicReference atomicReference, Object obj) {
        return (obj instanceof SessionMutex) && Intrinsics.areEqual(atomicReference, ((SessionMutex) obj).g());
    }

    public static final Object d(AtomicReference atomicReference) {
        Session session = (Session) atomicReference.get();
        if (session != null) {
            return session.b();
        }
        return null;
    }

    public static int e(AtomicReference atomicReference) {
        return atomicReference.hashCode();
    }

    public static String f(AtomicReference atomicReference) {
        return "SessionMutex(currentSessionHolder=" + atomicReference + ')';
    }

    public static final Object h(AtomicReference atomicReference, Function1 function1, Function2 function2, Continuation continuation) {
        return CoroutineScopeKt.f(new SessionMutex$withSessionCancellingPrevious$2(function1, atomicReference, function2, null), continuation);
    }

    public boolean equals(Object obj) {
        return c(this.f25178a, obj);
    }

    public final /* synthetic */ AtomicReference g() {
        return this.f25178a;
    }

    public int hashCode() {
        return e(this.f25178a);
    }

    public String toString() {
        return f(this.f25178a);
    }

    private static AtomicReference b(AtomicReference atomicReference) {
        return atomicReference;
    }
}
