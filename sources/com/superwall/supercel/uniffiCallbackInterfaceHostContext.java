package com.superwall.supercel;

import com.sun.jna.Pointer;
import com.superwall.supercel.RustBuffer;
import com.superwall.supercel.UniffiVTableCallbackInterfaceHostContext;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class uniffiCallbackInterfaceHostContext {
    public static final uniffiCallbackInterfaceHostContext INSTANCE = new uniffiCallbackInterfaceHostContext();
    private static UniffiVTableCallbackInterfaceHostContext.UniffiByValue vtable = new UniffiVTableCallbackInterfaceHostContext.UniffiByValue(computedProperty.INSTANCE, deviceProperty.INSTANCE, uniffiFree.INSTANCE);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class computedProperty implements UniffiCallbackInterfaceHostContextMethod0 {
        public static final computedProperty INSTANCE = new computedProperty();

        private computedProperty() {
        }

        @Override // com.superwall.supercel.UniffiCallbackInterfaceHostContextMethod0
        public void callback(long j3, final RustBuffer.ByValue name, final RustBuffer.ByValue args, final Pointer callback, Pointer uniffiOutReturn, UniffiRustCallStatus uniffiCallStatus) throws InternalException {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(args, "args");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(uniffiOutReturn, "uniffiOutReturn");
            Intrinsics.checkNotNullParameter(uniffiCallStatus, "uniffiCallStatus");
            final HostContext hostContext = FfiConverterTypeHostContext.INSTANCE.getHandleMap$supercel_release().get(j3);
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.superwall.supercel.uniffiCallbackInterfaceHostContext$computedProperty$callback$makeCall$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1355invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1355invoke() {
                    HostContext hostContext2 = hostContext;
                    FfiConverterString ffiConverterString = FfiConverterString.INSTANCE;
                    hostContext2.computedProperty(ffiConverterString.lift(name), ffiConverterString.lift(args), FfiConverterTypeResultCallback.INSTANCE.lift(callback));
                }
            };
            try {
                new Function1<Unit, Unit>() { // from class: com.superwall.supercel.uniffiCallbackInterfaceHostContext$computedProperty$callback$writeReturn$1
                    public final void invoke(Unit unit) {
                        Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 0>");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Unit) obj);
                        return Unit.f139807a;
                    }
                }.invoke(function0.invoke());
            } catch (Exception e3) {
                uniffiCallStatus.code = (byte) 2;
                uniffiCallStatus.error_buf = FfiConverterString.INSTANCE.lower(e3.toString());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class deviceProperty implements UniffiCallbackInterfaceHostContextMethod1 {
        public static final deviceProperty INSTANCE = new deviceProperty();

        private deviceProperty() {
        }

        @Override // com.superwall.supercel.UniffiCallbackInterfaceHostContextMethod1
        public void callback(long j3, final RustBuffer.ByValue name, final RustBuffer.ByValue args, final Pointer callback, Pointer uniffiOutReturn, UniffiRustCallStatus uniffiCallStatus) throws InternalException {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(args, "args");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(uniffiOutReturn, "uniffiOutReturn");
            Intrinsics.checkNotNullParameter(uniffiCallStatus, "uniffiCallStatus");
            final HostContext hostContext = FfiConverterTypeHostContext.INSTANCE.getHandleMap$supercel_release().get(j3);
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.superwall.supercel.uniffiCallbackInterfaceHostContext$deviceProperty$callback$makeCall$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1356invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1356invoke() {
                    HostContext hostContext2 = hostContext;
                    FfiConverterString ffiConverterString = FfiConverterString.INSTANCE;
                    hostContext2.deviceProperty(ffiConverterString.lift(name), ffiConverterString.lift(args), FfiConverterTypeResultCallback.INSTANCE.lift(callback));
                }
            };
            try {
                new Function1<Unit, Unit>() { // from class: com.superwall.supercel.uniffiCallbackInterfaceHostContext$deviceProperty$callback$writeReturn$1
                    public final void invoke(Unit unit) {
                        Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 0>");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Unit) obj);
                        return Unit.f139807a;
                    }
                }.invoke(function0.invoke());
            } catch (Exception e3) {
                uniffiCallStatus.code = (byte) 2;
                uniffiCallStatus.error_buf = FfiConverterString.INSTANCE.lower(e3.toString());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class uniffiFree implements UniffiCallbackInterfaceFree {
        public static final uniffiFree INSTANCE = new uniffiFree();

        private uniffiFree() {
        }

        @Override // com.superwall.supercel.UniffiCallbackInterfaceFree
        public void callback(long j3) throws InternalException {
            FfiConverterTypeHostContext.INSTANCE.getHandleMap$supercel_release().remove(j3);
        }
    }

    private uniffiCallbackInterfaceHostContext() {
    }

    public final UniffiVTableCallbackInterfaceHostContext.UniffiByValue getVtable$supercel_release() {
        return vtable;
    }

    public final void register$supercel_release(UniffiLib lib) {
        Intrinsics.checkNotNullParameter(lib, "lib");
        lib.uniffi_cel_eval_fn_init_callback_vtable_hostcontext(vtable);
    }

    public final void setVtable$supercel_release(UniffiVTableCallbackInterfaceHostContext.UniffiByValue uniffiByValue) {
        Intrinsics.checkNotNullParameter(uniffiByValue, "<set-?>");
        vtable = uniffiByValue;
    }
}
