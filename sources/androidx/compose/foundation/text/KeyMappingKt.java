package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;

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
public final class KeyMappingKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final KeyMapping f9748a;

    static {
        final KeyMapping keyMappingA = a(new PropertyReference1Impl() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(KeyEvent_androidKt.e(((KeyEvent) obj).f()));
            }
        });
        f9748a = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$2$1
            @Override // androidx.compose.foundation.text.KeyMapping
            public KeyCommand a(android.view.KeyEvent keyEvent) {
                KeyCommand keyCommand = null;
                if (KeyEvent_androidKt.f(keyEvent) && KeyEvent_androidKt.e(keyEvent)) {
                    long jA = KeyEvent_androidKt.a(keyEvent);
                    MappedKeys mappedKeys = MappedKeys.f9835a;
                    if (Key.p(jA, mappedKeys.i())) {
                        keyCommand = KeyCommand.K;
                    } else if (Key.p(jA, mappedKeys.j())) {
                        keyCommand = KeyCommand.L;
                    } else if (Key.p(jA, mappedKeys.k())) {
                        keyCommand = KeyCommand.N;
                    } else if (Key.p(jA, mappedKeys.h())) {
                        keyCommand = KeyCommand.M;
                    }
                } else if (KeyEvent_androidKt.e(keyEvent)) {
                    long jA2 = KeyEvent_androidKt.a(keyEvent);
                    MappedKeys mappedKeys2 = MappedKeys.f9835a;
                    if (Key.p(jA2, mappedKeys2.i())) {
                        keyCommand = KeyCommand.f9726f;
                    } else if (Key.p(jA2, mappedKeys2.j())) {
                        keyCommand = KeyCommand.f9725d;
                    } else if (Key.p(jA2, mappedKeys2.k())) {
                        keyCommand = KeyCommand.f9728h;
                    } else if (Key.p(jA2, mappedKeys2.h())) {
                        keyCommand = KeyCommand.f9727g;
                    } else if (Key.p(jA2, mappedKeys2.m())) {
                        keyCommand = KeyCommand.f9742v;
                    } else if (Key.p(jA2, mappedKeys2.g())) {
                        keyCommand = KeyCommand.f9745y;
                    } else if (Key.p(jA2, mappedKeys2.c())) {
                        keyCommand = KeyCommand.f9744x;
                    } else if (Key.p(jA2, mappedKeys2.b())) {
                        keyCommand = KeyCommand.S;
                    }
                } else if (KeyEvent_androidKt.f(keyEvent)) {
                    long jA3 = KeyEvent_androidKt.a(keyEvent);
                    MappedKeys mappedKeys3 = MappedKeys.f9835a;
                    if (Key.p(jA3, mappedKeys3.p())) {
                        keyCommand = KeyCommand.O;
                    } else if (Key.p(jA3, mappedKeys3.o())) {
                        keyCommand = KeyCommand.P;
                    }
                } else if (KeyEvent_androidKt.d(keyEvent)) {
                    long jA4 = KeyEvent_androidKt.a(keyEvent);
                    MappedKeys mappedKeys4 = MappedKeys.f9835a;
                    if (Key.p(jA4, mappedKeys4.c())) {
                        keyCommand = KeyCommand.f9746z;
                    } else if (Key.p(jA4, mappedKeys4.g())) {
                        keyCommand = KeyCommand.A;
                    }
                }
                return keyCommand == null ? keyMappingA.a(keyEvent) : keyCommand;
            }
        };
    }

    public static final KeyMapping a(final Function1 function1) {
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$commonKeyMapping$1
            @Override // androidx.compose.foundation.text.KeyMapping
            public KeyCommand a(android.view.KeyEvent keyEvent) {
                if (((Boolean) function1.invoke(KeyEvent.a(keyEvent))).booleanValue() && KeyEvent_androidKt.f(keyEvent)) {
                    if (Key.p(KeyEvent_androidKt.a(keyEvent), MappedKeys.f9835a.y())) {
                        return KeyCommand.W;
                    }
                    return null;
                }
                if (((Boolean) function1.invoke(KeyEvent.a(keyEvent))).booleanValue()) {
                    long jA = KeyEvent_androidKt.a(keyEvent);
                    MappedKeys mappedKeys = MappedKeys.f9835a;
                    if (Key.p(jA, mappedKeys.d()) ? true : Key.p(jA, mappedKeys.n())) {
                        return KeyCommand.f9739s;
                    }
                    if (Key.p(jA, mappedKeys.v())) {
                        return KeyCommand.f9740t;
                    }
                    if (Key.p(jA, mappedKeys.w())) {
                        return KeyCommand.f9741u;
                    }
                    if (Key.p(jA, mappedKeys.a())) {
                        return KeyCommand.B;
                    }
                    if (Key.p(jA, mappedKeys.x())) {
                        return KeyCommand.W;
                    }
                    if (Key.p(jA, mappedKeys.y())) {
                        return KeyCommand.V;
                    }
                    return null;
                }
                if (KeyEvent_androidKt.e(keyEvent)) {
                    return null;
                }
                if (KeyEvent_androidKt.f(keyEvent)) {
                    long jA2 = KeyEvent_androidKt.a(keyEvent);
                    MappedKeys mappedKeys2 = MappedKeys.f9835a;
                    if (Key.p(jA2, mappedKeys2.i())) {
                        return KeyCommand.C;
                    }
                    if (Key.p(jA2, mappedKeys2.j())) {
                        return KeyCommand.D;
                    }
                    if (Key.p(jA2, mappedKeys2.k())) {
                        return KeyCommand.E;
                    }
                    if (Key.p(jA2, mappedKeys2.h())) {
                        return KeyCommand.F;
                    }
                    if (Key.p(jA2, mappedKeys2.s())) {
                        return KeyCommand.G;
                    }
                    if (Key.p(jA2, mappedKeys2.r())) {
                        return KeyCommand.H;
                    }
                    if (Key.p(jA2, mappedKeys2.p())) {
                        return KeyCommand.O;
                    }
                    if (Key.p(jA2, mappedKeys2.o())) {
                        return KeyCommand.P;
                    }
                    if (Key.p(jA2, mappedKeys2.n())) {
                        return KeyCommand.f9740t;
                    }
                    return null;
                }
                long jA3 = KeyEvent_androidKt.a(keyEvent);
                MappedKeys mappedKeys3 = MappedKeys.f9835a;
                if (Key.p(jA3, mappedKeys3.i())) {
                    return KeyCommand.f9723b;
                }
                if (Key.p(jA3, mappedKeys3.j())) {
                    return KeyCommand.f9724c;
                }
                if (Key.p(jA3, mappedKeys3.k())) {
                    return KeyCommand.f9733m;
                }
                if (Key.p(jA3, mappedKeys3.h())) {
                    return KeyCommand.f9734n;
                }
                if (Key.p(jA3, mappedKeys3.s())) {
                    return KeyCommand.f9735o;
                }
                if (Key.p(jA3, mappedKeys3.r())) {
                    return KeyCommand.f9736p;
                }
                if (Key.p(jA3, mappedKeys3.p())) {
                    return KeyCommand.f9729i;
                }
                if (Key.p(jA3, mappedKeys3.o())) {
                    return KeyCommand.f9730j;
                }
                if (Key.p(jA3, mappedKeys3.l()) ? true : Key.p(jA3, mappedKeys3.q())) {
                    return KeyCommand.T;
                }
                if (Key.p(jA3, mappedKeys3.c())) {
                    return KeyCommand.f9742v;
                }
                if (Key.p(jA3, mappedKeys3.g())) {
                    return KeyCommand.f9743w;
                }
                if (Key.p(jA3, mappedKeys3.t())) {
                    return KeyCommand.f9740t;
                }
                if (Key.p(jA3, mappedKeys3.f())) {
                    return KeyCommand.f9741u;
                }
                if (Key.p(jA3, mappedKeys3.e())) {
                    return KeyCommand.f9739s;
                }
                if (Key.p(jA3, mappedKeys3.u())) {
                    return KeyCommand.U;
                }
                return null;
            }
        };
    }

    public static final KeyMapping b() {
        return f9748a;
    }
}
