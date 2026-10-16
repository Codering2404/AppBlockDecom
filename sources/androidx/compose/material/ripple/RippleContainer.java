package androidx.compose.material.ripple;

import android.content.Context;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
public final class RippleContainer extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f15386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f15387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RippleHostMap f15388d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15389f;

    public RippleContainer(Context context) {
        super(context);
        this.f15385a = 5;
        ArrayList arrayList = new ArrayList();
        this.f15386b = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f15387c = arrayList2;
        this.f15388d = new RippleHostMap();
        setClipChildren(false);
        RippleHostView rippleHostView = new RippleHostView(context);
        addView(rippleHostView);
        arrayList.add(rippleHostView);
        arrayList2.add(rippleHostView);
        this.f15389f = 1;
        setTag(androidx.compose.ui.R.id.J, Boolean.TRUE);
    }

    public final void a(RippleHostKey rippleHostKey) {
        rippleHostKey.x1();
        RippleHostView rippleHostViewB = this.f15388d.b(rippleHostKey);
        if (rippleHostViewB != null) {
            rippleHostViewB.d();
            this.f15388d.c(rippleHostKey);
            this.f15387c.add(rippleHostViewB);
        }
    }

    public final RippleHostView b(RippleHostKey rippleHostKey) {
        RippleHostView rippleHostViewB = this.f15388d.b(rippleHostKey);
        if (rippleHostViewB != null) {
            return rippleHostViewB;
        }
        RippleHostView rippleHostView = (RippleHostView) CollectionsKt.removeFirstOrNull(this.f15387c);
        if (rippleHostView == null) {
            if (this.f15389f > CollectionsKt.getLastIndex(this.f15386b)) {
                rippleHostView = new RippleHostView(getContext());
                addView(rippleHostView);
                this.f15386b.add(rippleHostView);
            } else {
                rippleHostView = (RippleHostView) this.f15386b.get(this.f15389f);
                RippleHostKey rippleHostKeyA = this.f15388d.a(rippleHostView);
                if (rippleHostKeyA != null) {
                    rippleHostKeyA.x1();
                    this.f15388d.c(rippleHostKeyA);
                    rippleHostView.d();
                }
            }
            int i3 = this.f15389f;
            if (i3 < this.f15385a - 1) {
                this.f15389f = i3 + 1;
            } else {
                this.f15389f = 0;
            }
        }
        this.f15388d.d(rippleHostKey, rippleHostView);
        return rippleHostView;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
    }
}
