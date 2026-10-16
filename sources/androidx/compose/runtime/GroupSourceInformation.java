package androidx.compose.runtime;

import java.util.ArrayList;
import kotlin.Metadata;
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
public final class GroupSourceInformation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f23900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList f23902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f23903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f23904f;

    private final void a(Object obj) {
        ArrayList arrayList = this.f23902d;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        this.f23902d = arrayList;
        arrayList.add(obj);
    }

    private final boolean h(Anchor anchor) {
        ArrayList arrayList = this.f23902d;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = arrayList.get(i3);
                if (Intrinsics.areEqual(obj, anchor)) {
                    return true;
                }
                if ((obj instanceof GroupSourceInformation) && ((GroupSourceInformation) obj).h(anchor)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final GroupSourceInformation i() {
        Object obj;
        GroupSourceInformation groupSourceInformationI;
        ArrayList arrayList = this.f23902d;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                obj = arrayList.get(size);
                if ((obj instanceof GroupSourceInformation) && !((GroupSourceInformation) obj).f23903e) {
                    break;
                }
            }
            obj = null;
        } else {
            obj = null;
        }
        GroupSourceInformation groupSourceInformation = obj instanceof GroupSourceInformation ? (GroupSourceInformation) obj : null;
        return (groupSourceInformation == null || (groupSourceInformationI = groupSourceInformation.i()) == null) ? this : groupSourceInformationI;
    }

    public final void b(SlotWriter slotWriter, int i3, int i4) {
        Anchor anchorO1;
        ArrayList arrayList = this.f23902d;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f23902d = arrayList;
        }
        int i5 = 0;
        if (i3 >= 0 && (anchorO1 = slotWriter.o1(i3)) != null) {
            int size = arrayList.size();
            while (true) {
                if (i5 >= size) {
                    i5 = -1;
                    break;
                }
                Object obj = arrayList.get(i5);
                if (Intrinsics.areEqual(obj, anchorO1) || ((obj instanceof GroupSourceInformation) && ((GroupSourceInformation) obj).h(anchorO1))) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        arrayList.add(i5, slotWriter.D(i4));
    }

    public final int c() {
        return this.f23904f;
    }

    public final int d() {
        return this.f23901c;
    }

    public final ArrayList e() {
        return this.f23902d;
    }

    public final int f() {
        return this.f23899a;
    }

    public final String g() {
        return this.f23900b;
    }

    public final boolean j(Anchor anchor) {
        ArrayList arrayList = this.f23902d;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Object obj = arrayList.get(size);
                if (obj instanceof Anchor) {
                    if (Intrinsics.areEqual(obj, anchor)) {
                        arrayList.remove(size);
                    }
                } else if ((obj instanceof GroupSourceInformation) && !((GroupSourceInformation) obj).j(anchor)) {
                    arrayList.remove(size);
                }
            }
            if (arrayList.isEmpty()) {
                this.f23902d = null;
                return false;
            }
        }
        return true;
    }

    public final void k(SlotTable slotTable, int i3) {
        i().a(slotTable.e(i3));
    }

    public final void l(SlotWriter slotWriter, int i3) {
        i().a(slotWriter.D(i3));
    }
}
