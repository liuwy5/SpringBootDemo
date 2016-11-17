/**
 * Created by ubuntu on 16-11-16.
 */

String.prototype.endWith = function (endStr) {
    var lastIndex = this.length - endStr.length;
    return (lastIndex > 0 && this.lastIndexOf(endStr) == lastIndex);
};
