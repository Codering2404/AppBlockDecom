package cz.mobilesoft.coreblock.rest.interceptor;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ErrorLogStore implements KoinComponent {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile long f98548f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ErrorLogStore f98544a = new ErrorLogStore();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ArrayDeque f98545b = new ArrayDeque(60);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ArrayDeque f98546c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Mutex f98547d = MutexKt.b(false, 1, null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f98549g = 8;

    private ErrorLogStore() {
    }

    private final synchronized void c(String str) {
        try {
            ArrayDeque arrayDeque = f98546c;
            if (arrayDeque.size() >= 10) {
                arrayDeque.removeFirst();
            }
            arrayDeque.addLast(str);
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized List f() {
        List list;
        ArrayDeque arrayDeque = f98546c;
        list = CollectionsKt.toList(arrayDeque);
        arrayDeque.clear();
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b1 A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #0 {all -> 0x00a0, blocks: (B:39:0x00a5, B:41:0x00b1, B:44:0x00b7, B:45:0x00bd, B:47:0x00cf, B:46:0x00c2, B:30:0x0077, B:32:0x0088), top: B:58:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.rest.interceptor.ErrorLogStore.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final synchronized void b(ApiLogEntry entry) {
        try {
            Intrinsics.checkNotNullParameter(entry, "entry");
            ArrayDeque arrayDeque = f98545b;
            if (arrayDeque.size() >= 60) {
                arrayDeque.removeFirst();
            }
            arrayDeque.addLast(entry);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized List d(long j3) {
        ArrayList arrayList;
        try {
            ArrayDeque arrayDeque = f98545b;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayDeque) {
                if (((ApiLogEntry) obj).a() != j3) {
                    arrayList2.add(obj);
                }
            }
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                arrayList.add(((ApiLogEntry) obj2).b());
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final Object e(List list, Continuation continuation) throws Throwable {
        if (list.isEmpty()) {
            return Unit.f139807a;
        }
        c(CollectionsKt.joinToString$default(list, "\n", null, null, 0, null, null, 62, null));
        Object objG = g(continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
