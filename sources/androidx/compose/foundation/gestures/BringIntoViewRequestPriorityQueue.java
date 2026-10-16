package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;

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
public final class BringIntoViewRequestPriorityQueue {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5542b = MutableVector.f24388d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableVector f5543a = new MutableVector(new ContentInViewNode.Request[16], 0);

    public final void b(Throwable th) {
        MutableVector mutableVector = this.f5543a;
        int iO = mutableVector.o();
        CancellableContinuation[] cancellableContinuationArr = new CancellableContinuation[iO];
        for (int i3 = 0; i3 < iO; i3++) {
            cancellableContinuationArr[i3] = ((ContentInViewNode.Request) mutableVector.f24389a[i3]).a();
        }
        for (int i4 = 0; i4 < iO; i4++) {
            cancellableContinuationArr[i4].cancel(th);
        }
        if (this.f5543a.o() == 0) {
            return;
        }
        InlineClassHelperKt.c("uncancelled requests present");
    }

    public final boolean c(final ContentInViewNode.Request request) {
        Rect rect = (Rect) request.b().invoke();
        if (rect == null) {
            CancellableContinuation cancellableContinuationA = request.a();
            Result.Companion companion = Result.f139772b;
            cancellableContinuationA.resumeWith(Result.b(Unit.f139807a));
            return false;
        }
        request.a().m(new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue$enqueue$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(Throwable th) {
                this.f5544a.f5543a.s(request);
            }
        });
        IntRange intRangeB = RangesKt.B(0, this.f5543a.o());
        int iG = intRangeB.g();
        int iH = intRangeB.h();
        if (iG <= iH) {
            while (true) {
                Rect rect2 = (Rect) ((ContentInViewNode.Request) this.f5543a.f24389a[iH]).b().invoke();
                if (rect2 != null) {
                    Rect rectX = rect.x(rect2);
                    if (Intrinsics.areEqual(rectX, rect)) {
                        this.f5543a.a(iH + 1, request);
                        return true;
                    }
                    if (!Intrinsics.areEqual(rectX, rect2)) {
                        CancellationException cancellationException = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
                        int iO = this.f5543a.o() - 1;
                        if (iO <= iH) {
                            while (true) {
                                ((ContentInViewNode.Request) this.f5543a.f24389a[iH]).a().cancel(cancellationException);
                                if (iO == iH) {
                                    break;
                                }
                                iO++;
                            }
                        }
                    }
                }
                if (iH == iG) {
                    break;
                }
                iH--;
            }
        }
        this.f5543a.a(0, request);
        return true;
    }

    public final void d() {
        IntRange intRangeB = RangesKt.B(0, this.f5543a.o());
        int iG = intRangeB.g();
        int iH = intRangeB.h();
        if (iG <= iH) {
            while (true) {
                ((ContentInViewNode.Request) this.f5543a.f24389a[iG]).a().resumeWith(Result.b(Unit.f139807a));
                if (iG == iH) {
                    break;
                } else {
                    iG++;
                }
            }
        }
        this.f5543a.i();
    }
}
