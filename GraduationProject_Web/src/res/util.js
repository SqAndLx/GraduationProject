export default {
    /**
     *
     * 创建时间
     * @returns
     */
    newTime() {
        return new Date().getTime()
    },
    /**
     *
     * 创建时间文字格式
     * @returns
     */
    getTime(time) {
        let timestamp = new Date(Number(time))
        let year = timestamp.getFullYear()
        let month = timestamp.getMonth() >= 9 ? timestamp.getMonth() + 1 : '0' + (timestamp.getMonth() + 1)
        let day = timestamp.getDate() > 9 ? timestamp.getDate() : '0' + timestamp.getDate()
        let hour = timestamp.getHours() > 10 ? timestamp.getHours() : '0' + timestamp.getHours()
        let min = timestamp.getMinutes() > 10 ? timestamp.getMinutes() : '0' + timestamp.getMinutes()
        let date = year + '-' + month + '-' + day + ' ' + hour + ':' + min
        return date
    },
    getTimeY(time) {
        let timestamp = new Date(time)
        let year = timestamp.getFullYear()
        let month = timestamp.getMonth() >= 9 ? timestamp.getMonth() + 1 : '0' + (timestamp.getMonth() + 1)
        let day = timestamp.getDate() > 9 ? timestamp.getDate() : '0' + timestamp.getDate()
        let date = year + '-' + month + '-' + day
        return date
    },
    /**
     *
     * 数组拼接
     * @param {*} arr1 数组1
     * @param {*} arr2 数组2
     * @returns
     */
    jointArry(arr1, arr2) {
        return [...arr1, ...arr2]
    },
    /**
     *
     * 本地存储
     * @param {*} name 存储标示
     * @param {*} data 存储数据 会自动转成字符串
     */
    localSet(name, data) {
        localStorage.setItem(name, JSON.stringify(data))
    },
    /**
     *
     * 本地存储
     * @param {*} name 存储标识
     * @returns
     */
    localGet(name) {
        return localStorage.getItem(name)
    },
    /**
     *
     * 字符串转对象 仅限json
     * @param {*} obj json
     * @returns
     */
    evalObj(obj) {
        return eval('(' + obj + ')')
    },
    /**
     *
     * 判断对象是否为空
     * @param {*} str
     * @returns
     */
    isEmpty(str) {
        if (str === null || str === '' || typeof(str) === 'undefined') {
            return true
        }
        return false
    },
    /**
     *
     * 数组 JSON 去重方法
     * @param {*} array 数组数据
     * @param {*} key 键值
     * @returns
     */
    removeRepeatEle(array, key) {
        let hash = {}
        var key = key
        const newArr = array.reduceRight((item, next) => {
            hash[next[key]] ? '' : hash[next[key]] = true && item.push(next)
            return item
        }, [])
        return newArr.reverse()
    },
    /**
     *
     * 数组去重
     * @param {*} array
     * @returns
     */
    removeRepeatArr(array) {
        return new Set(array)
    },
    /**
     *
     * 根据键值查找 对应数据 传递三个参数 返回数据和下标数组
     * @param {*} array 数据数组
     * @param {*} key 键值
     * @param {*} data 对应数据
     */
    searchData(array, key, data, type) {
        array.map((item, idx) => {
            if (item[key] === data) {
                if (arguments.length === 3) {
                    return item
                } else {
                    return [item, idx]
                }
            }
        })
    },
    /**
     *
     * 重构系列案数组
     * @param {*} array
     * @param {*} data
     * @param {*} key
     */
    setNotKey(array, data, key) {
        let type = true
        array.map((item, idx) => {
            if (item[0][key] === data[key]) {
                item.push(data)
                type = false
                return false
            }
        })
        if (type) {
            array.push(new Array(data))
        }
    },
    sortArray(arry) {
        arry.sort((a, b) => {
            return a - b
        })
    },
    sortArrayKey(arry, key) {
        arry.sort((a, b) => {
            return a[key] - b[key]
        })
    },
    /**
     *
     * 数组删除对应数据
     * @param {*} array
     * @param {*} data
     */
    removeElement(obj, array) {
        let index = array.indexOf(obj)
        if (index > -1) {
            array.splice(index, 1)
        }
    },
    parseParam(param, key) {
        console.log(param)
        try {
            var tempArr = [];
            for (var i in param) {
                var key = encodeURIComponent(i);
                var value = encodeURIComponent(param[i]);
                tempArr.push(key + '=' + value);
            }
            var urlParamsStr = tempArr.join('&');
            return urlParamsStr;
        } catch (err) {
            return '';
        }
    },
    getContentMaxHeight(element, offset = 40) {
        return window.innerHeight - element.$el.getBoundingClientRect().top - offset;
    }
}