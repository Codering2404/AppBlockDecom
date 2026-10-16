package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import java.text.BreakIterator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Pair;
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
public final class LayoutIntrinsics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f28961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextPaint f28962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f28964d = Float.NaN;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f28965e = Float.NaN;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BoringLayout.Metrics f28966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f28967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CharSequence f28968h;

    public LayoutIntrinsics(CharSequence charSequence, TextPaint textPaint, int i3) {
        this.f28961a = charSequence;
        this.f28962b = textPaint;
        this.f28963c = i3;
    }

    private final float b() {
        BoringLayout.Metrics metricsE = e();
        float fCeil = metricsE != null ? metricsE.width : -1;
        if (fCeil < 0.0f) {
            fCeil = (float) Math.ceil(h(this, 0, 0, 3, null));
        }
        return LayoutIntrinsics_androidKt.d(fCeil, this.f28961a, this.f28962b) ? fCeil + 0.5f : fCeil;
    }

    private final float c() {
        BreakIterator lineInstance = BreakIterator.getLineInstance(this.f28962b.getTextLocale());
        CharSequence charSequence = this.f28961a;
        int i3 = 0;
        lineInstance.setText(new CharSequenceCharacterIterator(charSequence, 0, charSequence.length()));
        PriorityQueue priorityQueue = new PriorityQueue(10, new Comparator() { // from class: androidx.compose.ui.text.android.u
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return LayoutIntrinsics.d((Pair) obj, (Pair) obj2);
            }
        });
        int next = lineInstance.next();
        while (true) {
            int i4 = i3;
            i3 = next;
            if (i3 == -1) {
                break;
            }
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new Pair(Integer.valueOf(i4), Integer.valueOf(i3)));
            } else {
                Pair pair = (Pair) priorityQueue.peek();
                if (pair != null && ((Number) pair.f()).intValue() - ((Number) pair.e()).intValue() < i3 - i4) {
                    priorityQueue.poll();
                    priorityQueue.add(new Pair(Integer.valueOf(i4), Integer.valueOf(i3)));
                }
            }
            next = lineInstance.next();
        }
        if (priorityQueue.isEmpty()) {
            return 0.0f;
        }
        Iterator it = priorityQueue.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Pair pair2 = (Pair) it.next();
        float fG = g(((Number) pair2.a()).intValue(), ((Number) pair2.b()).intValue());
        while (it.hasNext()) {
            Pair pair3 = (Pair) it.next();
            fG = Math.max(fG, g(((Number) pair3.a()).intValue(), ((Number) pair3.b()).intValue()));
        }
        return fG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(Pair pair, Pair pair2) {
        return (((Number) pair.f()).intValue() - ((Number) pair.e()).intValue()) - (((Number) pair2.f()).intValue() - ((Number) pair2.e()).intValue());
    }

    private final CharSequence f() {
        CharSequence charSequence = this.f28968h;
        if (charSequence != null) {
            Intrinsics.checkNotNull(charSequence);
            return charSequence;
        }
        if (!LayoutIntrinsics_androidKt.f28969a) {
            return this.f28961a;
        }
        CharSequence charSequenceE = LayoutIntrinsics_androidKt.e(this.f28961a);
        this.f28968h = charSequenceE;
        return charSequenceE;
    }

    private final float g(int i3, int i4) {
        return Layout.getDesiredWidth(f(), i3, i4, this.f28962b);
    }

    static /* synthetic */ float h(LayoutIntrinsics layoutIntrinsics, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = layoutIntrinsics.f().length();
        }
        return layoutIntrinsics.g(i3, i4);
    }

    public final BoringLayout.Metrics e() {
        if (!this.f28967g) {
            this.f28966f = BoringLayoutFactory.f28933a.c(this.f28961a, this.f28962b, TextLayout_androidKt.k(this.f28963c));
            this.f28967g = true;
        }
        return this.f28966f;
    }

    public final float i() {
        if (!Float.isNaN(this.f28964d)) {
            return this.f28964d;
        }
        float fB = b();
        this.f28964d = fB;
        return fB;
    }

    public final float j() {
        if (!Float.isNaN(this.f28965e)) {
            return this.f28965e;
        }
        float fC = c();
        this.f28965e = fC;
        return fC;
    }
}
