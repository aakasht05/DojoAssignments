    function starString(num) {
        var x = "";
        for (var i = 0; i < num; i++) {
            x += "*";
        }
        return x;
    }

    // function drawStars(arr) {

    //     for (var i = 0; i < arr.length; i++) {
    //         var output = "";
    //         for(var j = 0; j < arr[i]; j++){
    //             output += "*";
    //         }
    //        console.log(output);
    //     }
    // }

    function drawStars(arr) {

        for (var i = 0; i < arr.length; i++) {
            var output = "";
            if (arr[i].constructor === String) {
                for (var j = 0; j < arr[i].length; j++) {
                    output += arr[i][0].toLowerCase();
                }
            } else {
                for (var j = 0; j < arr[i]; j++) {
                    output += "*";
                }
            }
            console.log(output);
        }
    }


    let stars = starString(8);
    console.log(stars)
    console.log();
    // let x = [4, 6, 1, 3, 5, 7, 25];

    let x = [4, "Tom", 1, "Michael", 5, 7, "Jimmy Smith"];
    drawStars(x);