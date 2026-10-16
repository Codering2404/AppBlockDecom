package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

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
public class JobImpl extends JobSupport implements CompletableJob {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f140969c;

    public JobImpl(Job job) {
        super(true);
        v0(job);
        this.f140969c = b1();
    }

    private final boolean b1() {
        JobSupport jobSupportT;
        ChildHandle childHandleP0 = p0();
        ChildHandleNode childHandleNode = childHandleP0 instanceof ChildHandleNode ? (ChildHandleNode) childHandleP0 : null;
        if (childHandleNode != null && (jobSupportT = childHandleNode.t()) != null) {
            while (!jobSupportT.l0()) {
                ChildHandle childHandleP02 = jobSupportT.p0();
                ChildHandleNode childHandleNode2 = childHandleP02 instanceof ChildHandleNode ? (ChildHandleNode) childHandleP02 : null;
                if (childHandleNode2 == null || (jobSupportT = childHandleNode2.t()) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean a(Throwable th) {
        return B0(new CompletedExceptionally(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean b() {
        return B0(Unit.f139807a);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean l0() {
        return this.f140969c;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean n0() {
        return true;
    }
}
