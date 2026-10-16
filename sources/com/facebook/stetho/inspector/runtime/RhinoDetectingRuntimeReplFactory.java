package com.facebook.stetho.inspector.runtime;

import android.content.Context;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.console.RuntimeRepl;
import com.facebook.stetho.inspector.console.RuntimeReplFactory;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RhinoDetectingRuntimeReplFactory implements RuntimeReplFactory {
    private final Context mContext;
    private RuntimeException mRhinoJsUnexpectedError;
    private RuntimeReplFactory mRhinoReplFactory;
    private boolean mSearchedForRhinoJs;

    public RhinoDetectingRuntimeReplFactory(Context context) {
        this.mContext = context;
    }

    private static RuntimeReplFactory findRhinoReplFactory(Context context) throws RuntimeException {
        try {
            return (RuntimeReplFactory) Class.forName("com.facebook.stetho.rhino.JsRuntimeReplFactoryBuilder").getDeclaredMethod("defaultFactory", Context.class).invoke(null, context);
        } catch (ClassNotFoundException unused) {
            LogUtil.i("Error finding stetho-js-rhino, cannot enable console evaluation!");
            return null;
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override // com.facebook.stetho.inspector.console.RuntimeReplFactory
    public RuntimeRepl newInstance() {
        if (!this.mSearchedForRhinoJs) {
            this.mSearchedForRhinoJs = true;
            try {
                this.mRhinoReplFactory = findRhinoReplFactory(this.mContext);
            } catch (RuntimeException e3) {
                this.mRhinoJsUnexpectedError = e3;
            }
        }
        RuntimeReplFactory runtimeReplFactory = this.mRhinoReplFactory;
        return runtimeReplFactory != null ? runtimeReplFactory.newInstance() : new RuntimeRepl() { // from class: com.facebook.stetho.inspector.runtime.RhinoDetectingRuntimeReplFactory.1
            @Override // com.facebook.stetho.inspector.console.RuntimeRepl
            public Object evaluate(String str) throws Exception {
                if (RhinoDetectingRuntimeReplFactory.this.mRhinoJsUnexpectedError == null) {
                    return "Not supported without stetho-js-rhino dependency";
                }
                return "stetho-js-rhino threw: " + RhinoDetectingRuntimeReplFactory.this.mRhinoJsUnexpectedError.toString();
            }
        };
    }
}
