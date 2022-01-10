$(function(){

    const appendGame = function(data){
        var gameCode = '<a href="#" class="game-link" data-id="' +
            data.id + '">' + data.name + '</a><br>';
        $('#game-list')
            .append('<div>' + gameCode + '</div>');
    };

    //Loading games on load page
//    $.get('/games/', function(response)
//    {
//        for(i in response) {
//            appendGame(response[i]);
//        }
//    });

    //Show adding game form
    $('#show-add-game-form').click(function(){
        $('#game-form').css('display', 'flex');
    });

    //Closing adding game form
    $('#game-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Getting game
    $(document).on('click', '.game-link', function(){
        var link = $(this);
        var gameId = link.data('id');
        $.ajax({
            method: "GET",
            url: '/games/' + gameId,
            success: function(response)
            {
                var code = '<span>Возрастное ограничение: ' + response.year + '</span>' + '<span> Платформа : ' + response.platform + '</span>'
                           + '<span> Цена : ' + response.price + '</span>';
                link.parent().append(code);
            },
            error: function(response)
            {
                if(response.status == 404) {
                    alert('Игра не найдена!');
                }
            }
        });
        return false;
    });

    //Adding game
    $('#save-game').click(function()
    {
        var data = $('#game-form form').serialize();
        $.ajax({
            method: "POST",
            url: '/games/',
            data: data,
            success: function(response)
            {
                $('#game-form').css('display', 'none');
                var game = {};
                game.id = response;
                var dataArray = $('#game-form form').serializeArray();
                for(i in dataArray) {
                    game[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendGame(game);
            }
        });
        return false;
    });

    //Delete game
        $('#delete-game').click(function()
        {
            $.ajax({
                method: "DELETE" ,
                url: '/games/',
                success: function(response)
                {
                  $('#game-list').removeChild($('#game-list').childNodes['#idDelete']);
                }
            });
            return false;
    });

});

