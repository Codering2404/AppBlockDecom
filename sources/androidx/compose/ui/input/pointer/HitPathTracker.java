package androidx.compose.ui.input.pointer;

import androidx.collection.MutableLongObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class HitPathTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutCoordinates f26786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f26787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f26788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f26789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f26790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableObjectList f26791f = new MutableObjectList(0, 1, null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final NodeParent f26792g = new NodeParent();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableLongObjectMap f26793h = new MutableLongObjectMap(10);

    public HitPathTracker(LayoutCoordinates layoutCoordinates) {
        this.f26786a = layoutCoordinates;
    }

    private final void f(long j3, MutableObjectList mutableObjectList) {
        this.f26792g.h(j3, mutableObjectList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Modifier.Node node) {
        if (!this.f26787b) {
            this.f26792g.i(node);
        } else {
            this.f26790e = true;
            this.f26791f.n(node);
        }
    }

    public final void b(long j3, List list, boolean z2) {
        Object obj;
        NodeParent nodeParent = this.f26792g;
        this.f26793h.g();
        int size = list.size();
        boolean z3 = true;
        for (int i3 = 0; i3 < size; i3++) {
            final Modifier.Node node = (Modifier.Node) list.get(i3);
            if (node.isAttached()) {
                node.setDetachedListener$ui_release(new Function0<Unit>() { // from class: androidx.compose.ui.input.pointer.HitPathTracker$addHitPath$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m223invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m223invoke() {
                        this.f26794a.g(node);
                    }
                });
                if (z3) {
                    MutableVector mutableVectorG = nodeParent.g();
                    Object[] objArr = mutableVectorG.f24389a;
                    int iO = mutableVectorG.o();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= iO) {
                            obj = null;
                            break;
                        }
                        obj = objArr[i4];
                        if (Intrinsics.areEqual(((Node) obj).k(), node)) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    Node node2 = (Node) obj;
                    if (node2 != null) {
                        node2.n();
                        node2.l().a(j3);
                        MutableLongObjectMap mutableLongObjectMap = this.f26793h;
                        Object objB = mutableLongObjectMap.b(j3);
                        if (objB == null) {
                            objB = new MutableObjectList(0, 1, null);
                            mutableLongObjectMap.r(j3, objB);
                        }
                        ((MutableObjectList) objB).n(node2);
                        nodeParent = node2;
                    } else {
                        z3 = false;
                    }
                }
                Node node3 = new Node(node);
                node3.l().a(j3);
                MutableLongObjectMap mutableLongObjectMap2 = this.f26793h;
                Object objB2 = mutableLongObjectMap2.b(j3);
                if (objB2 == null) {
                    objB2 = new MutableObjectList(0, 1, null);
                    mutableLongObjectMap2.r(j3, objB2);
                }
                ((MutableObjectList) objB2).n(node3);
                nodeParent.g().b(node3);
                nodeParent = node3;
            }
        }
        if (!z2) {
            return;
        }
        MutableLongObjectMap mutableLongObjectMap3 = this.f26793h;
        long[] jArr = mutableLongObjectMap3.f2932b;
        Object[] objArr2 = mutableLongObjectMap3.f2933c;
        long[] jArr2 = mutableLongObjectMap3.f2931a;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j4 = jArr2[i5];
            if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j4) < 128) {
                        int i8 = (i5 << 3) + i7;
                        f(jArr[i8], (MutableObjectList) objArr2[i8]);
                    }
                    j4 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    public final void c() {
        if (this.f26789d) {
            this.f26789d = true;
        } else {
            this.f26792g.c();
        }
    }

    public final boolean d(InternalPointerEvent internalPointerEvent, boolean z2) {
        if (!this.f26792g.a(internalPointerEvent.b(), this.f26786a, internalPointerEvent, z2)) {
            return false;
        }
        boolean z3 = true;
        this.f26787b = true;
        boolean zF = this.f26792g.f(internalPointerEvent.b(), this.f26786a, internalPointerEvent, z2);
        if (!this.f26792g.e(internalPointerEvent) && !zF) {
            z3 = false;
        }
        this.f26787b = false;
        if (this.f26790e) {
            this.f26790e = false;
            int iE = this.f26791f.e();
            for (int i3 = 0; i3 < iE; i3++) {
                g((Modifier.Node) this.f26791f.d(i3));
            }
            this.f26791f.t();
        }
        if (this.f26788c) {
            this.f26788c = false;
            e();
        }
        if (this.f26789d) {
            this.f26789d = false;
            c();
        }
        return z3;
    }

    public final void e() {
        if (this.f26787b) {
            this.f26788c = true;
        } else {
            this.f26792g.d();
            c();
        }
    }
}
