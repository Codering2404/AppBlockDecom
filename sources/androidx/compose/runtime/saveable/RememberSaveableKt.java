package androidx.compose.runtime.saveable;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

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
public final class RememberSaveableKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24844a = 36;

    public static final String b(Object obj) {
        return obj + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
    }

    private static final Saver c(final Saver saver) {
        Intrinsics.checkNotNull(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver, kotlin.Any>");
        return SaverKt.a(new Function2<SaverScope, MutableState<Object>, MutableState<Object>>() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$mutableStateSaver$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final MutableState invoke(SaverScope saverScope, MutableState mutableState) {
                if (!(mutableState instanceof SnapshotMutableState)) {
                    throw new IllegalArgumentException("If you use a custom MutableState implementation you have to write a custom Saver and pass it as a saver param to rememberSaveable()");
                }
                Object objA = saver.a(saverScope, mutableState.getValue());
                if (objA == null) {
                    return null;
                }
                SnapshotMutationPolicy snapshotMutationPolicyF = ((SnapshotMutableState) mutableState).f();
                Intrinsics.checkNotNull(snapshotMutationPolicyF, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<kotlin.Any?>");
                return SnapshotStateKt.i(objA, snapshotMutationPolicyF);
            }
        }, new Function1<MutableState<Object>, MutableState<Object>>() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$mutableStateSaver$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final MutableState invoke(MutableState mutableState) {
                Object objB;
                if (!(mutableState instanceof SnapshotMutableState)) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                if (mutableState.getValue() != null) {
                    Saver saver2 = saver;
                    Object value = mutableState.getValue();
                    Intrinsics.checkNotNull(value);
                    objB = saver2.b(value);
                } else {
                    objB = null;
                }
                SnapshotMutationPolicy snapshotMutationPolicyF = ((SnapshotMutableState) mutableState).f();
                Intrinsics.checkNotNull(snapshotMutationPolicyF, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver?>");
                MutableState mutableStateI = SnapshotStateKt.i(objB, snapshotMutationPolicyF);
                Intrinsics.checkNotNull(mutableStateI, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver>");
                return mutableStateI;
            }
        });
    }

    public static final MutableState d(Object[] objArr, Saver saver, String str, Function0 function0, Composer composer, int i3, int i4) {
        if ((i4 & 4) != 0) {
            str = null;
        }
        String str2 = str;
        if (ComposerKt.M()) {
            ComposerKt.U(-202053668, i3, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:124)");
        }
        MutableState mutableState = (MutableState) e(Arrays.copyOf(objArr, objArr.length), c(saver), str2, function0, composer, i3 & 8064, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return mutableState;
    }

    public static final Object e(Object[] objArr, Saver saver, String str, Function0 function0, Composer composer, int i3, int i4) {
        Object[] objArr2;
        final Object obj;
        Object objF;
        if ((i4 & 2) != 0) {
            saver = SaverKt.b();
        }
        final Saver saver2 = saver;
        int i5 = i4 & 4;
        Object objInvoke = null;
        if (i5 != 0) {
            str = null;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(441892779, i3, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:70)");
        }
        int iA = ComposablesKt.a(composer, 0);
        if (str == null || str.length() == 0) {
            str = Integer.toString(iA, CharsKt.checkRadix(f24844a));
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        }
        final String str2 = str;
        Intrinsics.checkNotNull(saver2, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>");
        final SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) composer.q(SaveableStateRegistryKt.e());
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            if (saveableStateRegistry != null && (objF = saveableStateRegistry.f(str2)) != null) {
                objInvoke = saver2.b(objF);
            }
            if (objInvoke == null) {
                objInvoke = function0.invoke();
            }
            objArr2 = objArr;
            Object saveableHolder = new SaveableHolder(saver2, saveableStateRegistry, str2, objInvoke, objArr2);
            composer.w(saveableHolder);
            objG = saveableHolder;
        } else {
            objArr2 = objArr;
        }
        final SaveableHolder saveableHolder2 = (SaveableHolder) objG;
        Object objG2 = saveableHolder2.g(objArr2);
        if (objG2 == null) {
            objG2 = function0.invoke();
        }
        boolean zI = composer.I(saveableHolder2) | ((((i3 & 112) ^ 48) > 32 && composer.I(saver2)) || (i3 & 48) == 32) | composer.I(saveableStateRegistry) | composer.Z(str2) | composer.I(objG2) | composer.I(objArr2);
        Object objG3 = composer.G();
        if (zI || objG3 == companion.a()) {
            final Object[] objArr3 = objArr2;
            obj = objG2;
            Object obj2 = new Function0<Unit>() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m207invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m207invoke() {
                    saveableHolder2.i(saver2, saveableStateRegistry, str2, obj, objArr3);
                }
            };
            composer.w(obj2);
            objG3 = obj2;
        } else {
            obj = objG2;
        }
        EffectsKt.j((Function0) objG3, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(SaveableStateRegistry saveableStateRegistry, Object obj) {
        String strB;
        if (obj == null || saveableStateRegistry.a(obj)) {
            return;
        }
        if (obj instanceof SnapshotMutableState) {
            SnapshotMutableState snapshotMutableState = (SnapshotMutableState) obj;
            if (snapshotMutableState.f() == SnapshotStateKt.k() || snapshotMutableState.f() == SnapshotStateKt.r() || snapshotMutableState.f() == SnapshotStateKt.o()) {
                strB = "MutableState containing " + snapshotMutableState.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
            } else {
                strB = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
            }
        } else {
            strB = b(obj);
        }
        throw new IllegalArgumentException(strB);
    }
}
