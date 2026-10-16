package androidx.compose.ui.platform;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.WeakReference;
import androidx.compose.ui.text.input.NullableInputConnectionWrapper;
import androidx.compose.ui.text.input.NullableInputConnectionWrapper_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class InputMethodSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PlatformTextInputMethodRequest f28099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f28100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f28101c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MutableVector f28102d = new MutableVector(new WeakReference[16], 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f28103e;

    public InputMethodSession(PlatformTextInputMethodRequest platformTextInputMethodRequest, Function0 function0) {
        this.f28099a = platformTextInputMethodRequest;
        this.f28100b = function0;
    }

    public final InputConnection c(EditorInfo editorInfo) {
        synchronized (this.f28101c) {
            if (this.f28103e) {
                return null;
            }
            NullableInputConnectionWrapper nullableInputConnectionWrapperA = NullableInputConnectionWrapper_androidKt.a(this.f28099a.a(editorInfo), new Function1<NullableInputConnectionWrapper, Unit>() { // from class: androidx.compose.ui.platform.InputMethodSession$createInputConnection$1$1
                {
                    super(1);
                }

                public final void c(NullableInputConnectionWrapper nullableInputConnectionWrapper) {
                    nullableInputConnectionWrapper.a();
                    MutableVector mutableVector = this.f28104a.f28102d;
                    Object[] objArr = mutableVector.f24389a;
                    int iO = mutableVector.o();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= iO) {
                            i3 = -1;
                            break;
                        } else if (Intrinsics.areEqual((WeakReference) objArr[i3], nullableInputConnectionWrapper)) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i3 >= 0) {
                        this.f28104a.f28102d.u(i3);
                    }
                    if (this.f28104a.f28102d.o() == 0) {
                        this.f28104a.f28100b.invoke();
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((NullableInputConnectionWrapper) obj);
                    return Unit.f139807a;
                }
            });
            this.f28102d.b(new WeakReference(nullableInputConnectionWrapperA));
            return nullableInputConnectionWrapperA;
        }
    }

    public final void d() {
        synchronized (this.f28101c) {
            try {
                this.f28103e = true;
                MutableVector mutableVector = this.f28102d;
                Object[] objArr = mutableVector.f24389a;
                int iO = mutableVector.o();
                for (int i3 = 0; i3 < iO; i3++) {
                    NullableInputConnectionWrapper nullableInputConnectionWrapper = (NullableInputConnectionWrapper) ((WeakReference) objArr[i3]).get();
                    if (nullableInputConnectionWrapper != null) {
                        nullableInputConnectionWrapper.a();
                    }
                }
                this.f28102d.i();
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean e() {
        return !this.f28103e;
    }
}
