package io.fabianterhorst.iron;

public interface Cache {

    void evictAll();

    Object put(String key, Object value);

    Object get(String key);

    Object remove(String key);

    void setStorage(Storage storage);

    Cache MEMORY = new LruCache();

    Cache NONE = new Cache() {

        Storage storage;

        @Override
        public void evictAll() {
        }

        @Override
        public Object put(String key, Object value) {
            return null;
        }

        @Override
        public Object get(String key) {
            return storage.doSelect(key);
        }

        @Override
        public Object remove(String key) {
            return null;
        }

        @Override
        public void setStorage(Storage storage) {
            this.storage = storage;
        }
    };
}