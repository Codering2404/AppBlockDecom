package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

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
public final class MotionEventAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f26807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseLongArray f26808b = new SparseLongArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseBooleanArray f26809c = new SparseBooleanArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f26810d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f26811e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f26812f = -1;

    private final void a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 9) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            if (this.f26808b.indexOfKey(pointerId) < 0) {
                SparseLongArray sparseLongArray = this.f26808b;
                long j3 = this.f26807a;
                this.f26807a = 1 + j3;
                sparseLongArray.put(pointerId, j3);
                return;
            }
            return;
        }
        int actionIndex = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex);
        if (this.f26808b.indexOfKey(pointerId2) < 0) {
            SparseLongArray sparseLongArray2 = this.f26808b;
            long j4 = this.f26807a;
            this.f26807a = 1 + j4;
            sparseLongArray2.put(pointerId2, j4);
            if (motionEvent.getToolType(actionIndex) == 3) {
                this.f26809c.put(pointerId2, true);
            }
        }
    }

    private final void b(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType == this.f26811e && source == this.f26812f) {
            return;
        }
        this.f26811e = toolType;
        this.f26812f = source;
        this.f26809c.clear();
        this.f26808b.clear();
    }

    private final PointerInputEventData d(PositionCalculator positionCalculator, MotionEvent motionEvent, int i3, boolean z2) {
        long jX;
        long jA;
        int i4;
        long jF = f(motionEvent.getPointerId(i3));
        float pressure = motionEvent.getPressure(i3);
        char c3 = ' ';
        long j3 = 4294967295L;
        long jE = Offset.e((((long) Float.floatToRawIntBits(motionEvent.getY(i3))) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getX(i3))) << 32));
        long jG = Offset.g(jE, 0.0f, 0.0f, 3, null);
        if (i3 == 0) {
            jA = Offset.e((((long) Float.floatToRawIntBits(motionEvent.getRawY())) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getRawX())) << 32));
            jX = positionCalculator.x(jA);
        } else if (Build.VERSION.SDK_INT >= 29) {
            jA = MotionEventHelper.f26813a.a(motionEvent, i3);
            jX = positionCalculator.x(jA);
        } else {
            long jH = positionCalculator.H(jE);
            jX = jE;
            jA = jH;
        }
        int toolType = motionEvent.getToolType(i3);
        int iE = toolType != 0 ? toolType != 1 ? toolType != 2 ? toolType != 3 ? toolType != 4 ? PointerType.f26922b.e() : PointerType.f26922b.a() : PointerType.f26922b.b() : PointerType.f26922b.c() : PointerType.f26922b.d() : PointerType.f26922b.e();
        ArrayList arrayList = new ArrayList(motionEvent.getHistorySize());
        int historySize = motionEvent.getHistorySize();
        int i5 = 0;
        while (i5 < historySize) {
            float historicalX = motionEvent.getHistoricalX(i3, i5);
            float historicalY = motionEvent.getHistoricalY(i3, i5);
            char c4 = c3;
            long j4 = j3;
            if ((Float.floatToRawIntBits(historicalX) & Api.BaseClientBuilder.API_PRIORITY_OTHER) >= 2139095040 || (Float.floatToRawIntBits(historicalY) & Api.BaseClientBuilder.API_PRIORITY_OTHER) >= 2139095040) {
                i4 = i5;
            } else {
                long jE2 = Offset.e((((long) Float.floatToRawIntBits(historicalX)) << c4) | (((long) Float.floatToRawIntBits(historicalY)) & j4));
                i4 = i5;
                arrayList.add(new HistoricalChange(motionEvent.getHistoricalEventTime(i4), jE2, jE2, null));
            }
            i5 = i4 + 1;
            c3 = c4;
            j3 = j4;
        }
        return new PointerInputEventData(jF, motionEvent.getEventTime(), jA, jX, z2, pressure, iE, this.f26809c.get(motionEvent.getPointerId(i3), false), arrayList, motionEvent.getActionMasked() == 8 ? Offset.e((((long) Float.floatToRawIntBits((-motionEvent.getAxisValue(9)) + 0.0f)) & j3) | (((long) Float.floatToRawIntBits(motionEvent.getAxisValue(10))) << c3)) : Offset.f25596b.c(), jG, null);
    }

    private final long f(int i3) {
        long jValueAt;
        int iIndexOfKey = this.f26808b.indexOfKey(i3);
        if (iIndexOfKey >= 0) {
            jValueAt = this.f26808b.valueAt(iIndexOfKey);
        } else {
            jValueAt = this.f26807a;
            this.f26807a = 1 + jValueAt;
            this.f26808b.put(i3, jValueAt);
        }
        return PointerId.a(jValueAt);
    }

    private final boolean g(MotionEvent motionEvent, int i3) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i4 = 0; i4 < pointerCount; i4++) {
            if (motionEvent.getPointerId(i4) == i3) {
                return true;
            }
        }
        return false;
    }

    private final void h(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.f26809c.get(pointerId, false)) {
                this.f26808b.delete(pointerId);
                this.f26809c.delete(pointerId);
            }
        }
        if (this.f26808b.size() > motionEvent.getPointerCount()) {
            for (int size = this.f26808b.size() - 1; -1 < size; size--) {
                int iKeyAt = this.f26808b.keyAt(size);
                if (!g(motionEvent, iKeyAt)) {
                    this.f26808b.removeAt(size);
                    this.f26809c.delete(iKeyAt);
                }
            }
        }
    }

    public final PointerInputEvent c(MotionEvent motionEvent, PositionCalculator positionCalculator) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 4) {
            this.f26808b.clear();
            this.f26809c.clear();
            return null;
        }
        b(motionEvent);
        a(motionEvent);
        boolean z2 = actionMasked == 9 || actionMasked == 7 || actionMasked == 10;
        boolean z3 = actionMasked == 8;
        if (z2) {
            this.f26809c.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        int actionIndex = actionMasked != 1 ? actionMasked != 6 ? -1 : motionEvent.getActionIndex() : 0;
        this.f26810d.clear();
        int pointerCount = motionEvent.getPointerCount();
        int i3 = 0;
        while (i3 < pointerCount) {
            this.f26810d.add(d(positionCalculator, motionEvent, i3, (z2 || i3 == actionIndex || (z3 && motionEvent.getButtonState() == 0)) ? false : true));
            i3++;
        }
        h(motionEvent);
        return new PointerInputEvent(motionEvent.getEventTime(), this.f26810d, motionEvent);
    }

    public final void e(int i3) {
        this.f26809c.delete(i3);
        this.f26808b.delete(i3);
    }
}
