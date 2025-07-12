    <%@ include file="header.jsp" %>

    <div class="instructions">
        <span>Please note:</span>
        <ul>
            <li>Participants must be accompanied by a parent or guardian</li>
            <li>Participants must come with their kits (Jersey, Shorts, Long socks, and football boots)</li>
        </ul>
    </div>
    <form action="/event/processregistration" method="POST">
        <span>parent information</span>
        <div class="parent">
            <label for="title" class="required">Title: </label>
            <select name="title" id="title">
                <option value="">Please Select</option>
                <option value="Mr">Mr.</option>
                <option value="Mrs.">Mrs.</option>
                <option value="Miss">Miss</option>
            </select>
            <label for="firstname" class="required">firstname: </label>
            <input type="text" name="firstname" id="firstname" onkeypress="validateAlphaInput(event)" onpaste="validatePastedAlphaInput(event)" required>
            <label for="lastname" class="required">lastname: </label>
            <input type="text" name="lastname" id="lastname" onkeypress="validateAlphaInput(event)" onpaste="validatePastedAlphaInput(event)" required>
            <label for="phone" class="required">phone: </label>
            <input type="text" name="phone" id="phone" onkeypress="validateInput(event)" onpaste="validatePastedInput(event)" required>
            <label for="email">email: </label>
            <input type="text" name="email" id="email">
            <label for="address">Address: </label>
            <input type="text" name="address" id="address">
        </div>

        <hr>

        <span>player information</span>
        <div class="player">
            <label for="childFirstname" class="required">firstname: </label>
            <input type="text" name="childFirstname" id="childFirstname" onkeypress="validateAlphaInput(event)" onpaste="validatePastedAlphaInput(event)" required>
            <label for="childLastname" class="required">lastname: </label>
            <input type="text" name="childLastname" id="childLastname" onkeypress="validateAlphaInput(event)" onpaste="validatePastedAlphaInput(event)" required>
            <label for="dob" class="required">birth: </label>
            <input type="date" name="dob" id="dob" min="2012-01-01" max="2017-12-01" required>
            <label for="gender">gender: </label>
            <select name="gender" id="gender">
                <option value="">Please Select</option>
                <option value="M">Male</option>
                <option value="F">Female</option>
            </select>

        </div>
        <label for="med" class="long required">Does the player have any medical condition that could affect his/her participation?</label>
            <select name="med" id="med" required>
                <option value="">Please Select</option>
                <option value="yes">Yes</option>
                <option value="no">No</option>
            </select>

        <button>submit</button>
    </form>

</body>

</html>