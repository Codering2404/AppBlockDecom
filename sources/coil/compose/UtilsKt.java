package coil.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSizeKt;
import coil.compose.AsyncImagePainter;
import coil.request.ImageRequest;
import coil.request.NullRequestDataException;
import coil.size.Scale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class UtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f55676a = Constraints.f29963b.c(0, 0);

    public static final float a(long j3, float f3) {
        return RangesKt.o(f3, Constraints.m(j3), Constraints.k(j3));
    }

    public static final float b(long j3, float f3) {
        return RangesKt.o(f3, Constraints.n(j3), Constraints.l(j3));
    }

    public static final long c() {
        return f55676a;
    }

    public static final Function1 d(final Function1 function1, final Function1 function12, final Function1 function13) {
        if (function1 == null && function12 == null && function13 == null) {
            return null;
        }
        return new Function1<AsyncImagePainter.State, Unit>() { // from class: coil.compose.UtilsKt$onStateOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(AsyncImagePainter.State state) {
                Function1 function14;
                if (state instanceof AsyncImagePainter.State.Loading) {
                    Function1 function15 = function1;
                    if (function15 != null) {
                        function15.invoke(state);
                        return;
                    }
                    return;
                }
                if (state instanceof AsyncImagePainter.State.Success) {
                    Function1 function16 = function12;
                    if (function16 != null) {
                        function16.invoke(state);
                        return;
                    }
                    return;
                }
                if (!(state instanceof AsyncImagePainter.State.Error) || (function14 = function13) == null) {
                    return;
                }
                function14.invoke(state);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((AsyncImagePainter.State) obj);
                return Unit.f139807a;
            }
        };
    }

    public static final ImageRequest e(Object obj, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1151830858, i3, -1, "coil.compose.requestOf (Utils.kt:21)");
        }
        return obj instanceof ImageRequest ? (ImageRequest) obj : new ImageRequest.Builder((Context) composer.q(AndroidCompositionLocals_androidKt.g())).d(obj).a();
    }

    public static final long f(long j3) {
        return IntSizeKt.a(MathKt.d(Size.i(j3)), MathKt.d(Size.g(j3)));
    }

    public static final Scale g(ContentScale contentScale) {
        ContentScale.Companion companion = ContentScale.f27054a;
        return Intrinsics.areEqual(contentScale, companion.e()) ? true : Intrinsics.areEqual(contentScale, companion.f()) ? Scale.FIT : Scale.FILL;
    }

    public static final Function1 h(final Painter painter, final Painter painter2, final Painter painter3) {
        return (painter == null && painter2 == null && painter3 == null) ? AsyncImagePainter.f55509w.a() : new Function1<AsyncImagePainter.State, AsyncImagePainter.State>() { // from class: coil.compose.UtilsKt$transformOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final AsyncImagePainter.State invoke(AsyncImagePainter.State state) {
                if (state instanceof AsyncImagePainter.State.Loading) {
                    Painter painter4 = painter;
                    AsyncImagePainter.State.Loading loading = (AsyncImagePainter.State.Loading) state;
                    return painter4 != null ? loading.b(painter4) : loading;
                }
                if (!(state instanceof AsyncImagePainter.State.Error)) {
                    return state;
                }
                AsyncImagePainter.State.Error error = (AsyncImagePainter.State.Error) state;
                if (error.d().c() instanceof NullRequestDataException) {
                    Painter painter5 = painter3;
                    return painter5 != null ? AsyncImagePainter.State.Error.c(error, painter5, null, 2, null) : error;
                }
                Painter painter6 = painter2;
                return painter6 != null ? AsyncImagePainter.State.Error.c(error, painter6, null, 2, null) : error;
            }
        };
    }
}
