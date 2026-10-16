package androidx.compose.runtime;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.collection.ExtensionsKt;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class MovableContentState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SlotTable f23954a;

    public MovableContentState(SlotTable slotTable) {
        this.f23954a = slotTable;
    }

    private static final void a(SlotWriter slotWriter, int i3) {
        while (slotWriter.e0() >= 0 && slotWriter.d0() <= i3) {
            slotWriter.Z0();
            slotWriter.T();
        }
    }

    private static final void b(SlotWriter slotWriter, int i3) {
        a(slotWriter, i3);
        while (slotWriter.c0() != i3 && !slotWriter.s0()) {
            if (i3 < ComposerKt.F(slotWriter)) {
                slotWriter.j1();
            } else {
                slotWriter.Y0();
            }
        }
        if (!(slotWriter.c0() == i3)) {
            ComposerKt.t("Unexpected slot table structure");
        }
        slotWriter.j1();
    }

    public final ScatterMap c(Applier applier, ObjectList objectList) {
        Object[] objArr = objectList.f3081a;
        int i3 = objectList.f3082b;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = 1;
            if (i5 >= i3) {
                break;
            }
            if (this.f23954a.D(((MovableContentStateReference) objArr[i5]).a())) {
                i5++;
            } else {
                MutableObjectList mutableObjectList = new MutableObjectList(i4, i6, null);
                Object[] objArr2 = objectList.f3081a;
                int i7 = objectList.f3082b;
                for (int i8 = 0; i8 < i7; i8++) {
                    Object obj = objArr2[i8];
                    if (this.f23954a.D(((MovableContentStateReference) obj).a())) {
                        mutableObjectList.n(obj);
                    }
                }
                objectList = mutableObjectList;
            }
        }
        ObjectList objectListD = ExtensionsKt.d(objectList, new Function1<MovableContentStateReference, Integer>() { // from class: androidx.compose.runtime.MovableContentState$extractNestedStates$referencesToExtract$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Integer invoke(MovableContentStateReference movableContentStateReference) {
                return Integer.valueOf(this.f23955a.d().f(movableContentStateReference.a()));
            }
        });
        if (objectListD.g()) {
            return ScatterMapKt.a();
        }
        MutableScatterMap mutableScatterMapC = ScatterMapKt.c();
        SlotWriter slotWriterC = this.f23954a.C();
        try {
            Object[] objArr3 = objectListD.f3081a;
            int i9 = objectListD.f3082b;
            for (int i10 = 0; i10 < i9; i10++) {
                MovableContentStateReference movableContentStateReference = (MovableContentStateReference) objArr3[i10];
                int iE = slotWriterC.E(movableContentStateReference.a());
                int iI0 = slotWriterC.I0(iE);
                a(slotWriterC, iI0);
                b(slotWriterC, iI0);
                slotWriterC.C(iE - slotWriterC.c0());
                mutableScatterMapC.x(movableContentStateReference, ComposerKt.x(movableContentStateReference.b(), movableContentStateReference, slotWriterC, applier));
            }
            a(slotWriterC, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            Unit unit = Unit.f139807a;
            slotWriterC.L(true);
            return mutableScatterMapC;
        } catch (Throwable th) {
            slotWriterC.L(false);
            throw th;
        }
    }

    public final SlotTable d() {
        return this.f23954a;
    }
}
