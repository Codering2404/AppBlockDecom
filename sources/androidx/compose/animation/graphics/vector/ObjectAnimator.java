package androidx.compose.animation.graphics.vector;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.core.RepeatMode;
import com.google.android.gms.common.api.Api;
import java.util.List;
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
public final class ObjectAnimator extends Animator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RepeatMode f4417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f4418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f4419f;

    public ObjectAnimator(int i3, int i4, int i5, RepeatMode repeatMode, List list) {
        super(null);
        this.f4414a = i3;
        this.f4415b = i4;
        this.f4416c = i5;
        this.f4417d = repeatMode;
        this.f4418e = list;
        this.f4419f = i5 == -1 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (i3 * (i5 + 1)) + i4;
    }

    @Override // androidx.compose.animation.graphics.vector.Animator
    public void b(MutableScatterMap mutableScatterMap, int i3, int i4) {
        List list = this.f4418e;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            PropertyValuesHolder propertyValuesHolder = (PropertyValuesHolder) list.get(i5);
            if (!(propertyValuesHolder instanceof PropertyValuesHolder2D)) {
                if (propertyValuesHolder instanceof PropertyValuesHolderFloat) {
                    PropertyValuesHolderFloat propertyValuesHolderFloat = (PropertyValuesHolderFloat) propertyValuesHolder;
                    FloatPropertyValues floatPropertyValues = (FloatPropertyValues) mutableScatterMap.e(propertyValuesHolderFloat.a());
                    if (floatPropertyValues == null) {
                        floatPropertyValues = new FloatPropertyValues();
                    }
                    FloatPropertyValues floatPropertyValues2 = floatPropertyValues;
                    floatPropertyValues2.c().add(new Timestamp(this.f4415b + i4, this.f4414a, this.f4416c, this.f4417d, propertyValuesHolder));
                    mutableScatterMap.x(propertyValuesHolderFloat.a(), floatPropertyValues2);
                } else if (propertyValuesHolder instanceof PropertyValuesHolderColor) {
                    PropertyValuesHolderColor propertyValuesHolderColor = (PropertyValuesHolderColor) propertyValuesHolder;
                    ColorPropertyValues colorPropertyValues = (ColorPropertyValues) mutableScatterMap.e(propertyValuesHolderColor.a());
                    if (colorPropertyValues == null) {
                        colorPropertyValues = new ColorPropertyValues();
                    }
                    ColorPropertyValues colorPropertyValues2 = colorPropertyValues;
                    colorPropertyValues2.c().add(new Timestamp(this.f4415b + i4, this.f4414a, this.f4416c, this.f4417d, propertyValuesHolder));
                    mutableScatterMap.x(propertyValuesHolderColor.a(), colorPropertyValues2);
                } else if (propertyValuesHolder instanceof PropertyValuesHolderPath) {
                    PropertyValuesHolderPath propertyValuesHolderPath = (PropertyValuesHolderPath) propertyValuesHolder;
                    PathPropertyValues pathPropertyValues = (PathPropertyValues) mutableScatterMap.e(propertyValuesHolderPath.a());
                    if (pathPropertyValues == null) {
                        pathPropertyValues = new PathPropertyValues();
                    }
                    PathPropertyValues pathPropertyValues2 = pathPropertyValues;
                    pathPropertyValues2.c().add(new Timestamp(this.f4415b + i4, this.f4414a, this.f4416c, this.f4417d, propertyValuesHolder));
                    mutableScatterMap.x(propertyValuesHolderPath.a(), pathPropertyValues2);
                }
            }
        }
    }

    @Override // androidx.compose.animation.graphics.vector.Animator
    public int d() {
        return this.f4419f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ObjectAnimator)) {
            return false;
        }
        ObjectAnimator objectAnimator = (ObjectAnimator) obj;
        return this.f4414a == objectAnimator.f4414a && this.f4415b == objectAnimator.f4415b && this.f4416c == objectAnimator.f4416c && this.f4417d == objectAnimator.f4417d && Intrinsics.areEqual(this.f4418e, objectAnimator.f4418e);
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.f4414a) * 31) + Integer.hashCode(this.f4415b)) * 31) + Integer.hashCode(this.f4416c)) * 31) + this.f4417d.hashCode()) * 31) + this.f4418e.hashCode();
    }

    public String toString() {
        return "ObjectAnimator(duration=" + this.f4414a + ", startDelay=" + this.f4415b + ", repeatCount=" + this.f4416c + ", repeatMode=" + this.f4417d + ", holders=" + this.f4418e + ')';
    }
}
