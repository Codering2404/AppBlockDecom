package com.facebook.internal;

import com.facebook.FacebookException;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CollectionMapper {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Collection<T> {
        Object get(T t2);

        Iterator<T> keyIterator();

        void set(T t2, Object obj, OnErrorListener onErrorListener);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnMapValueCompleteListener extends OnErrorListener {
        void onComplete(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnMapperCompleteListener extends OnErrorListener {
        void onComplete();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ValueMapper {
        void mapValue(Object obj, OnMapValueCompleteListener onMapValueCompleteListener);
    }

    private CollectionMapper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void iterate(final Collection<T> collection, ValueMapper valueMapper, final OnMapperCompleteListener onMapperCompleteListener) {
        final Mutable mutable = new Mutable(Boolean.FALSE);
        final Mutable mutable2 = new Mutable(1);
        final OnMapperCompleteListener onMapperCompleteListener2 = new OnMapperCompleteListener() { // from class: com.facebook.internal.CollectionMapper.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Integer] */
            @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
            public void onComplete() {
                if (((Boolean) mutable.value).booleanValue()) {
                    return;
                }
                Mutable mutable3 = mutable2;
                int iIntValue = ((Integer) mutable3.value).intValue() - 1;
                mutable3.value = Integer.valueOf(iIntValue);
                if (iIntValue == 0) {
                    onMapperCompleteListener.onComplete();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Boolean] */
            @Override // com.facebook.internal.CollectionMapper.OnErrorListener
            public void onError(FacebookException facebookException) {
                if (((Boolean) mutable.value).booleanValue()) {
                    return;
                }
                mutable.value = Boolean.TRUE;
                onMapperCompleteListener.onError(facebookException);
            }
        };
        Iterator itKeyIterator = collection.keyIterator();
        LinkedList linkedList = new LinkedList();
        while (itKeyIterator.hasNext()) {
            linkedList.add(itKeyIterator.next());
        }
        for (final Object obj : linkedList) {
            Object obj2 = collection.get(obj);
            OnMapValueCompleteListener onMapValueCompleteListener = new OnMapValueCompleteListener() { // from class: com.facebook.internal.CollectionMapper.2
                @Override // com.facebook.internal.CollectionMapper.OnMapValueCompleteListener
                public void onComplete(Object obj3) {
                    collection.set(obj, obj3, onMapperCompleteListener2);
                    onMapperCompleteListener2.onComplete();
                }

                @Override // com.facebook.internal.CollectionMapper.OnErrorListener
                public void onError(FacebookException facebookException) {
                    onMapperCompleteListener2.onError(facebookException);
                }
            };
            T t2 = mutable2.value;
            mutable2.value = (T) Integer.valueOf(((Integer) t2).intValue() + 1);
            valueMapper.mapValue(obj2, onMapValueCompleteListener);
        }
        onMapperCompleteListener2.onComplete();
    }
}
