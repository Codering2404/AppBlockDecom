package androidx.compose.animation.graphics.vector;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.VectorConfig;
import androidx.compose.ui.graphics.vector.VectorProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class StateVectorConfig implements VectorConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private State f4445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private State f4446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private State f4447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private State f4448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private State f4449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private State f4450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private State f4451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private State f4452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private State f4453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private State f4454j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private State f4455k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private State f4456l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private State f4457m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private State f4458n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private State f4459o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private State f4460p;

    @Override // androidx.compose.ui.graphics.vector.VectorConfig
    public Object a(VectorProperty vectorProperty, Object obj) {
        List list;
        if (vectorProperty instanceof VectorProperty.Rotation) {
            State state = this.f4445a;
            if (state != null) {
                return Float.valueOf(((Number) state.getValue()).floatValue());
            }
        } else if (vectorProperty instanceof VectorProperty.PivotX) {
            State state2 = this.f4446b;
            if (state2 != null) {
                return Float.valueOf(((Number) state2.getValue()).floatValue());
            }
        } else if (vectorProperty instanceof VectorProperty.PivotY) {
            State state3 = this.f4447c;
            if (state3 != null) {
                return Float.valueOf(((Number) state3.getValue()).floatValue());
            }
        } else if (vectorProperty instanceof VectorProperty.ScaleX) {
            State state4 = this.f4448d;
            if (state4 != null) {
                return Float.valueOf(((Number) state4.getValue()).floatValue());
            }
        } else if (vectorProperty instanceof VectorProperty.ScaleY) {
            State state5 = this.f4449e;
            if (state5 != null) {
                return Float.valueOf(((Number) state5.getValue()).floatValue());
            }
        } else if (vectorProperty instanceof VectorProperty.TranslateX) {
            State state6 = this.f4450f;
            if (state6 != null) {
                return Float.valueOf(((Number) state6.getValue()).floatValue());
            }
        } else if (vectorProperty instanceof VectorProperty.TranslateY) {
            State state7 = this.f4451g;
            if (state7 != null) {
                return Float.valueOf(((Number) state7.getValue()).floatValue());
            }
        } else if (vectorProperty instanceof VectorProperty.PathData) {
            State state8 = this.f4452h;
            if (state8 != null && (list = (List) state8.getValue()) != null) {
                return list;
            }
        } else {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (vectorProperty instanceof VectorProperty.Fill) {
                State state9 = this.f4453i;
                if (state9 != null) {
                    return new SolidColor(((Color) state9.getValue()).B(), defaultConstructorMarker);
                }
            } else if (vectorProperty instanceof VectorProperty.FillAlpha) {
                State state10 = this.f4457m;
                if (state10 != null) {
                    return Float.valueOf(((Number) state10.getValue()).floatValue());
                }
            } else if (vectorProperty instanceof VectorProperty.Stroke) {
                State state11 = this.f4454j;
                if (state11 != null) {
                    return new SolidColor(((Color) state11.getValue()).B(), defaultConstructorMarker);
                }
            } else if (vectorProperty instanceof VectorProperty.StrokeLineWidth) {
                State state12 = this.f4455k;
                if (state12 != null) {
                    return Float.valueOf(((Number) state12.getValue()).floatValue());
                }
            } else if (vectorProperty instanceof VectorProperty.StrokeAlpha) {
                State state13 = this.f4456l;
                if (state13 != null) {
                    return Float.valueOf(((Number) state13.getValue()).floatValue());
                }
            } else if (vectorProperty instanceof VectorProperty.TrimPathStart) {
                State state14 = this.f4458n;
                if (state14 != null) {
                    return Float.valueOf(((Number) state14.getValue()).floatValue());
                }
            } else if (vectorProperty instanceof VectorProperty.TrimPathEnd) {
                State state15 = this.f4459o;
                if (state15 != null) {
                    return Float.valueOf(((Number) state15.getValue()).floatValue());
                }
            } else {
                if (!(vectorProperty instanceof VectorProperty.TrimPathOffset)) {
                    throw new NoWhenBranchMatchedException();
                }
                State state16 = this.f4460p;
                if (state16 != null) {
                    return Float.valueOf(((Number) state16.getValue()).floatValue());
                }
            }
        }
        return obj;
    }

    public final void b(StateVectorConfig stateVectorConfig) {
        State state = stateVectorConfig.f4445a;
        if (state != null) {
            this.f4445a = state;
        }
        State state2 = stateVectorConfig.f4446b;
        if (state2 != null) {
            this.f4446b = state2;
        }
        State state3 = stateVectorConfig.f4447c;
        if (state3 != null) {
            this.f4447c = state3;
        }
        State state4 = stateVectorConfig.f4448d;
        if (state4 != null) {
            this.f4448d = state4;
        }
        State state5 = stateVectorConfig.f4449e;
        if (state5 != null) {
            this.f4449e = state5;
        }
        State state6 = stateVectorConfig.f4450f;
        if (state6 != null) {
            this.f4450f = state6;
        }
        State state7 = stateVectorConfig.f4451g;
        if (state7 != null) {
            this.f4451g = state7;
        }
        State state8 = stateVectorConfig.f4452h;
        if (state8 != null) {
            this.f4452h = state8;
        }
        State state9 = stateVectorConfig.f4453i;
        if (state9 != null) {
            this.f4453i = state9;
        }
        State state10 = stateVectorConfig.f4454j;
        if (state10 != null) {
            this.f4454j = state10;
        }
        State state11 = stateVectorConfig.f4455k;
        if (state11 != null) {
            this.f4455k = state11;
        }
        State state12 = stateVectorConfig.f4456l;
        if (state12 != null) {
            this.f4456l = state12;
        }
        State state13 = stateVectorConfig.f4457m;
        if (state13 != null) {
            this.f4457m = state13;
        }
        State state14 = stateVectorConfig.f4458n;
        if (state14 != null) {
            this.f4458n = state14;
        }
        State state15 = stateVectorConfig.f4459o;
        if (state15 != null) {
            this.f4459o = state15;
        }
        State state16 = stateVectorConfig.f4460p;
        if (state16 != null) {
            this.f4460p = state16;
        }
    }

    public final void c(State state) {
        this.f4457m = state;
    }

    public final void d(State state) {
        this.f4453i = state;
    }

    public final void e(State state) {
        this.f4452h = state;
    }

    public final void f(State state) {
        this.f4446b = state;
    }

    public final void g(State state) {
        this.f4447c = state;
    }

    public final void h(State state) {
        this.f4445a = state;
    }

    public final void i(State state) {
        this.f4448d = state;
    }

    public final void j(State state) {
        this.f4449e = state;
    }

    public final void k(State state) {
        this.f4456l = state;
    }

    public final void l(State state) {
        this.f4454j = state;
    }

    public final void m(State state) {
        this.f4455k = state;
    }

    public final void n(State state) {
        this.f4450f = state;
    }

    public final void o(State state) {
        this.f4451g = state;
    }

    public final void p(State state) {
        this.f4459o = state;
    }

    public final void q(State state) {
        this.f4460p = state;
    }

    public final void r(State state) {
        this.f4458n = state;
    }
}
