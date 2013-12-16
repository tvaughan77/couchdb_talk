function(doc) {
    if ('random' in doc) {
        emit(doc.random, doc.name);
    }
}