function(doc) {
    if ('name' in doc) {
        emit(doc.name, doc._id);
    }
}